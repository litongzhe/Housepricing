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
        }
        return new ResultVo(ResultCode.OK,resultList);
    }
}
