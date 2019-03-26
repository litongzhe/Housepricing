package com.raising.modules.buildingPrice.service;

import com.raising.framework.entity.ResultCode;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;
import com.raising.modules.buildingPrice.entity.LoupanPicEntity;
import com.raising.modules.buildingPrice.entity.QueryInfoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.buildingPrice.dao.InfodataDao;
import com.raising.modules.buildingPrice.entity.InfodataEntity;

import java.util.*;

/**
 * Service层
 *
 * @author fsd
 * @createTime 2019-03-04 14:17:51
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class InfodataService extends CrudService<InfodataDao, InfodataEntity> {

    /**
     * 获取 在价格面积区间内获取 Page信息
     *
     * @param
     * @param
     * @return
     * @author fsd
     */

    @Autowired
    LoupanPicService loupanPicService;

    /**
     * 按照价格和面积 寻找对应的楼盘
     * @param page
     * @return
     */
    public ResultVo getPageByPriceArea(Page<QueryInfoData> page) {
        List<QueryInfoData> list = this.dao.getPageByPriceArea(page);

        List<String> urls = new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            urls.add(list.get(i).getUrl());
        }
        ResultVo result = loupanPicService.getOnePicByUrl(urls);
        if (result.getCode() != ResultVo.SUCCESS)
            return result;
        List<LoupanPicEntity> picList = (List<LoupanPicEntity>) result.getData();
        int i = 0;
        for (QueryInfoData item : list) {
            item.setUrl(picList.get(i++).getPic());
        }
         page.setResults(list);
        return new ResultVo(ResultCode.OK, page);
    }

    /**
     * 根据一个楼盘的信息 筛选出与之相似的楼盘信息
     * @param queryInfoData
     * @param BestNum
     * @return
     */
    public ResultVo getSimilarLoupanByOneLoupan(QueryInfoData queryInfoData, String[] featureList, Integer BestNum) {

        List<QueryInfoData> candidateEntitys = this.dao.getSimilarList(queryInfoData);
        //异常处理，没有合适的数据
        if(candidateEntitys == null){
            candidateEntitys = new ArrayList<>();
        }
        //去除这个楼盘
        if(candidateEntitys.size()>=1){
            for(Integer index = 0; index < candidateEntitys.size() ; index++){
                QueryInfoData item = candidateEntitys.get(index);
                if(item.getXiaoqu().equals(queryInfoData.getXiaoqu())){
                    candidateEntitys.remove(item);
                    break;
                }
            }
        }
        if(candidateEntitys.size()<=BestNum){
            return new ResultVo(ResultCode.OK,candidateEntitys);
        }
        //3、进一步筛选，按照共有features的数量，进行排序
        Map<Integer,Integer> entityScore = new HashMap<>();
        for(Integer index =0 ; index < candidateEntitys.size(); index++){
            Integer sameFeatureNum = 0;
            for(String f: featureList){
                if(candidateEntitys.get(index).getProjectfeatures().indexOf(f) != -1){
                    sameFeatureNum ++;
                }
            }
            entityScore.put(index,sameFeatureNum);
        }
        //4、排序
        List<Map.Entry<Integer,Integer>> entityScoreList = new ArrayList<Map.Entry<Integer, Integer>>(entityScore.entrySet());
        Collections.sort(entityScoreList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //5、输出前BestNum个
        List<InfodataEntity> resultList = new ArrayList<>();
        Integer num = 0;
        for(Map.Entry<Integer,Integer> mapping : entityScoreList){
            if(num >= BestNum){
                break;
            }
            resultList.add(candidateEntitys.get(mapping.getKey()));
            num += 1;
        }
        return new ResultVo(ResultCode.OK,resultList);
    }

    /**
     * 封装好的接口，输入任意infodata  根据城市 房屋类型 价格面积 返回 相似楼盘
     * @param infodataEntity
     * @return
     */
    public ResultVo getSimilarLoupan(InfodataEntity infodataEntity, Integer BestNum){
        //1、相似属性：获取当前小区的城市，区，房屋类别，价格，面积，特征短语
        String cityName = infodataEntity.getCity();
        String regionName = infodataEntity.getRegion();
        String propertyType = infodataEntity.getPropertytype();
        String features = infodataEntity.getProjectfeatures();
        String price = infodataEntity.getPrice();
        String area = infodataEntity.getArea();
        String[] featureList = features.split(" ");
        //2、初筛：先按照城市,户型,价格区间，面积区间 初筛，得到一个候选楼盘list  (因为用户偏向于查看同一个城市同一类型的 楼盘)
        QueryInfoData queryInfoData = new QueryInfoData();
        queryInfoData.setCity(cityName);
        queryInfoData.setPropertytype(propertyType);

        if (area!=null && !area.equals("暂无信息")){
            queryInfoData.setStartArea(Integer.valueOf(area)-50);
            queryInfoData.setEndArea(Integer.valueOf(area)+50);
        }
        if (price!=null && !price.equals("暂无信息")){
            queryInfoData.setStartPrice(Integer.valueOf(price)-10000);
            queryInfoData.setEndPrice(Integer.valueOf(price)+10000);
        }
        //获取bestNum 个相似楼盘信息
        ResultVo resultVoquery = this.getSimilarLoupanByOneLoupan(queryInfoData,featureList, BestNum);
        //存入字典返回，格式为 小区名：相似楼盘list
        List<InfodataEntity> resultList = (List<InfodataEntity>)resultVoquery.getData();

        return new ResultVo(ResultCode.OK, resultList);
    }


    /**
     * 选出 多个限制条件下的
     * @param page
     * @return
     */
    public ResultVo multiChoose(Page<QueryInfoData> page, List<String> featureList){
        List<QueryInfoData> originalChooseResult = this.dao.multiChoose(page);
        //1、进一步按照 features 筛选,去除不包含特征的 楼盘
        //2、feature  为空直接返回
        if(featureList == null || featureList.size()==0){
            page.setResults(originalChooseResult);
            return new ResultVo(ResultCode.OK,page);
        }
        //2、feature 不为空，则继续筛选出合适的结果
        Map<Integer,Integer> resultScore = new HashMap<>();
        for(Integer index =0 ; index < originalChooseResult.size(); index++){
            QueryInfoData original = originalChooseResult.get(index);
            Integer sameFeatureNum = 0;
            for(String feature:featureList){
                if(original.getProjectfeatures().contains(feature)){
                    sameFeatureNum += 1;
                }
            }
            resultScore.put(index,sameFeatureNum);
        }
        //3、排序
        List<Map.Entry<Integer,Integer>> resultScoreList = new ArrayList<Map.Entry<Integer, Integer>>(resultScore.entrySet());
        Collections.sort(resultScoreList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //4、输出包含属性的楼盘
        List<QueryInfoData> resultList = new ArrayList<>();
        for(Map.Entry<Integer,Integer> mapping : resultScoreList){
            if(mapping.getValue() > 0){
                resultList.add(originalChooseResult.get(mapping.getKey()));
            }
        }
        page.setResults(resultList);
        page.setPageSize(resultList.size());
        return new ResultVo(ResultCode.OK,page);
    }

}
