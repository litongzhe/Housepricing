package com.raising.modules.buildingPrice.controller;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.raising.framework.entity.ResultCode;
import com.raising.modules.buildingPrice.entity.BuildColBrowEntity;
import com.raising.modules.buildingPrice.entity.LoupanPicEntity;
import com.raising.modules.buildingPrice.entity.QueryInfoData;
import com.raising.modules.buildingPrice.service.BuildColBrowService;
import com.raising.modules.buildingPrice.service.LoupanPicService;
import net.sf.json.JSONArray;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raising.framework.controller.BaseController;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;

import com.raising.modules.buildingPrice.entity.InfodataEntity;
import com.raising.modules.buildingPrice.service.InfodataService;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * 控制器
 *
 * @author fsd
 * @createTime 2019-03-04 14:17:51
 */
@RestController
@RequestMapping("/buildingPrice/infodata")
public class InfodataController extends BaseController {

    @Autowired
    private InfodataService infodataService;
    @Autowired
    private BuildColBrowService buildColBrowService;
    @Autowired
    private LoupanPicService loupanPicService;

    /**
     * 分页 - 查询
     *
     * @param page
     * @param infodata
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-04 14:17:51
     */
    // @RequiresPermissions("buildingPrice:infodata:select")
    @GetMapping("/page")
    public ResultVo page(QueryInfoData infodata, Page<QueryInfoData> page) {
        page.setEntity(infodata);
//        HashMap<String, String> map = new HashMap<>();
//        map.put("startPrice", startPrice);
//        map.put("endPrice", endPrice);
//        map.put("startArea", startArea);
//        map.put("endArea", endArea);
        ResultVo resultVo = infodataService.getPageByPriceArea(page);
        return resultVo;
    }

    /**
     * 详情 - 查询
     *
     * @param id
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-04 14:17:51
     */
    // @RequiresPermissions("buildingPrice:infodata:select")
    @GetMapping("/info")
    public ResultVo info(@RequestParam("id") String id) {

        InfodataEntity info = (InfodataEntity) infodataService.get(id).getData();
        BuildColBrowEntity buildColBrowEntity = new BuildColBrowEntity();
        buildColBrowEntity.setXiaoquid(id);
        ResultVo resultVo = buildColBrowService.increaseBrowse(buildColBrowEntity);
        if (resultVo.getCode() != ResultCode.OK.getCode()) {
            return resultVo;
        } else {
            ResultVo re2 = loupanPicService.getListPicByUrl(info.getUrl());
            if (re2.getCode() == 13) {
                return re2;
            }
            List<LoupanPicEntity> loupanPicEntities = (List<LoupanPicEntity>) re2.getData();
            BuildColBrowEntity buildColBrowEntity1 = (BuildColBrowEntity) buildColBrowService.get(id).getData();

            HashMap<String, Object> result2view = new HashMap<>();
            result2view.put("buildInfo", info);
            result2view.put("picList", loupanPicEntities);
            result2view.put("coll", buildColBrowEntity1);
            resultVo.setData(result2view);
            return resultVo;
        }


    }

    /**
     * 新增 - 插入
     *
     * @param infodata
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-04 14:17:51
     */
    // @RequiresPermissions("buildingPrice:infodata:insert")
    @PostMapping("/insert")
    public ResultVo insert(InfodataEntity infodata) {
        InfodataEntity insert = new InfodataEntity();
        //赋值至 insert 对象
        insert.setDate(infodata.getDate());
        insert.setCity(infodata.getCity());
        insert.setRegion(infodata.getRegion());
        insert.setXiaoqu(infodata.getXiaoqu());
        insert.setPrice(infodata.getPrice());
        insert.setTotal(infodata.getTotal());
        insert.setUrl(infodata.getUrl());
        insert.setPropertytype(infodata.getPropertytype());
        insert.setReferenceprice(infodata.getReferenceprice());
        insert.setProjectfeatures(infodata.getProjectfeatures());
        insert.setRegionallocation(infodata.getRegionallocation());
        insert.setPropertyaddress(infodata.getPropertyaddress());
        insert.setSalesofficeaddress(infodata.getSalesofficeaddress());
        insert.setDeveloper(infodata.getDeveloper());
        insert.setBuildingtype(infodata.getBuildingtype());
        insert.setLandscapingratio(infodata.getLandscapingratio());
        insert.setSitearea(infodata.getSitearea());
        insert.setFloorarearatio(infodata.getFloorarearatio());
        insert.setBuildingarea(infodata.getBuildingarea());
        insert.setYearofpropertyrights(infodata.getYearofpropertyrights());
        insert.setNumplan(infodata.getNumplan());
        insert.setDesigntype(infodata.getDesigntype());
        insert.setPropertycompany(infodata.getPropertycompany());
        insert.setParkingratio(infodata.getParkingratio());
        insert.setPropertycosts(infodata.getPropertycosts());
        insert.setHeatingmethod(infodata.getHeatingmethod());
        insert.setWatersupplymethod(infodata.getWatersupplymethod());
        insert.setPowersupply(infodata.getPowersupply());
        insert.setParkingspace(infodata.getParkingspace());
        insert.setNearby(infodata.getNearby());
        insert.setArea(infodata.getArea());
        insert.setId(infodata.getId());
        ResultVo resultVo = infodataService.insert(insert);
        resultVo.setData(insert.getId());
        return resultVo;
    }

    /**
     * 更新
     *
     * @param infodata
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-04 14:17:51
     */
    // @RequiresPermissions("buildingPrice:infodata:update")
    @PostMapping("/update")
    public ResultVo update(InfodataEntity infodata) {
        InfodataEntity update = new InfodataEntity();
        //赋值至 update 对象
        update.setDate(infodata.getDate());
        update.setCity(infodata.getCity());
        update.setRegion(infodata.getRegion());
        update.setXiaoqu(infodata.getXiaoqu());
        update.setPrice(infodata.getPrice());
        update.setTotal(infodata.getTotal());
        update.setUrl(infodata.getUrl());
        update.setPropertytype(infodata.getPropertytype());
        update.setReferenceprice(infodata.getReferenceprice());
        update.setProjectfeatures(infodata.getProjectfeatures());
        update.setRegionallocation(infodata.getRegionallocation());
        update.setPropertyaddress(infodata.getPropertyaddress());
        update.setSalesofficeaddress(infodata.getSalesofficeaddress());
        update.setDeveloper(infodata.getDeveloper());
        update.setBuildingtype(infodata.getBuildingtype());
        update.setLandscapingratio(infodata.getLandscapingratio());
        update.setSitearea(infodata.getSitearea());
        update.setFloorarearatio(infodata.getFloorarearatio());
        update.setBuildingarea(infodata.getBuildingarea());
        update.setYearofpropertyrights(infodata.getYearofpropertyrights());
        update.setNumplan(infodata.getNumplan());
        update.setDesigntype(infodata.getDesigntype());
        update.setPropertycompany(infodata.getPropertycompany());
        update.setParkingratio(infodata.getParkingratio());
        update.setPropertycosts(infodata.getPropertycosts());
        update.setHeatingmethod(infodata.getHeatingmethod());
        update.setWatersupplymethod(infodata.getWatersupplymethod());
        update.setPowersupply(infodata.getPowersupply());
        update.setParkingspace(infodata.getParkingspace());
        update.setNearby(infodata.getNearby());
        update.setArea(infodata.getArea());
        update.setId(infodata.getId());
        return infodataService.update(update);
    }

    /**
     * 删除
     *
     * @param id
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-04 14:17:51
     */
    // @RequiresPermissions("buildingPrice:infodata:delete")
    @PostMapping("/delete")
    public ResultVo delete(@RequestParam("id") String id) {
        return infodataService.delete(id);
    }


    /**
     * 给出一个楼盘  同一区域 的相似房源
     *
     * @param infodataEntity
     * @return
     * @author fsd
     */
    @GetMapping("/getSimilarByOneLoupan")
    public ResultVo getSimilarByOneLoupan(InfodataEntity infodataEntity) {

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

        if (!area.equals("None") && area != null && !area.equals("暂无信息") && !area.equals("")) {
            queryInfoData.setStartArea((int) (Double.valueOf(area) - 50));
            queryInfoData.setEndArea((int) (Double.valueOf(area) + 50));
        }
        if (!price.equals("None") && price != null && !price.equals("价格待定") && !price.equals("")) {
            queryInfoData.setStartPrice((int) (Double.valueOf(price) - 10000));
            queryInfoData.setEndPrice((int) (Double.valueOf(price) + 10000));
        }
        //获取bestNum 个相似楼盘信息
        ResultVo resultVoquery = infodataService.getSimilarLoupanByOneLoupan(queryInfoData, featureList, 6);
        //存入字典返回，格式为 小区名：相似楼盘list
        List<InfodataEntity> resultList = (List<InfodataEntity>) resultVoquery.getData();
        Map<String, List<InfodataEntity>> result = new HashMap<>();
//        result.put(infodataEntity.getXiaoqu(), resultList);
        result.put("results", resultList);
        return new ResultVo(ResultCode.OK, result);
    }

    /**
     * 根据多个条件查找 对应楼盘
     *
     * @param queryInfoData
     * @param page
     * @return
     */
    @PostMapping("/searchByMultiInfo")
    public ResultVo searchByMultiInfo(QueryInfoData queryInfoData, Page<QueryInfoData> page) {
        page.setEntity(queryInfoData);
        List<String> featureList = queryInfoData.getProjectFeaturesList();
        return infodataService.multiChoose(page, featureList);
    }


    /**
     * 给出一个城市或一个地区的收藏量前10的楼盘
     *
     * @param city,region
     * @return resultVo
     * @author litongzhe
     */
    @GetMapping("/getAheadLoupan")
    public ResultVo getAheadLoupan(@RequestParam("city") String city, @RequestParam("region") String region) {
        InfodataEntity infodataEntity = new InfodataEntity();
        infodataEntity.setCity(city);
        List<InfodataEntity> infodataEntities;
        if (region.equals("无")) {//城市范围
            infodataEntities = (List<InfodataEntity>) infodataService.getAheadLoupanByCity(infodataEntity).getData();
        } else {//区范围
            infodataEntity.setRegion(region);
            infodataEntities = (List<InfodataEntity>) infodataService.getAheadLoupanByRegion(infodataEntity).getData();
        }
        Map<String, Integer> id2collectnum = Maps.newLinkedHashMap();

        BuildColBrowEntity buildColBrowEntity = new BuildColBrowEntity();
        List<BuildColBrowEntity> buildColBrowEntities = (List<BuildColBrowEntity>) buildColBrowService.getList(buildColBrowEntity).getData();

        Map<String, Integer> allid2collectnum = Maps.newLinkedHashMap();
        for (BuildColBrowEntity e : buildColBrowEntities) {
            allid2collectnum.put(e.getXiaoquid(), Integer.valueOf(e.getCollectnum()));
        }
        for (InfodataEntity e : infodataEntities) {
            String id = e.getId();
            Integer collectnum;
            if (allid2collectnum.containsKey(id)) {
                collectnum = allid2collectnum.get(id);
            } else {
                collectnum = 0;
            }
            id2collectnum.put(id, collectnum);
        }
//        BuildColBrowEntity buildColBrowEntity = new BuildColBrowEntity();
//        BuildColBrowEntity result = new BuildColBrowEntity();
//
//
//        for(InfodataEntity e:infodataEntities){
//            String id = e.getId();
//            Integer collectnum;
//            buildColBrowEntity.setXiaoquid(id);
//            result = (BuildColBrowEntity)buildColBrowService.getByID(buildColBrowEntity).getData();
//            if(result == null){//收藏表中不存在说明收藏量为0
//                collectnum = 0;
//            }
//            else{
//                collectnum = Integer.valueOf(result.getCollectnum());
//            }
//            id2collectnum.put(id,collectnum);
//        }

        Map<String, Integer> resultMap = Maps.newLinkedHashMap();//排序后的map
        Stream<Map.Entry<String, Integer>> st = id2collectnum.entrySet().stream();
        st.sorted(Comparator.comparing(e -> -e.getValue())).forEach(e -> resultMap.put(e.getKey(), e.getValue()));//加-号表示从大到小排序
        Integer num = 0;
        Map<String, Integer> copyMap = Maps.newLinkedHashMap();
        copyMap.putAll(resultMap);//要展示的小区 id:收藏量
        if (copyMap.size() > 10) {
            for (String key : resultMap.keySet()) {
                num++;
                if (num > 10) {
                    copyMap.remove(key);
                }
            }
        }
        List<Map> resultList = new ArrayList<>();//要展示的所有小区

        for (InfodataEntity e : infodataEntities) {
            if (copyMap.containsKey(e.getId())) {
                Map<String, Object> map = Maps.newLinkedHashMap();
                LoupanPicEntity loupanPicEntity = new LoupanPicEntity();
                map.put("Information", e);
                String url = e.getUrl();
                loupanPicEntity.setUrl(url);
                List urlList = new ArrayList();
                urlList.add(url);
                loupanPicEntity = ((List<LoupanPicEntity>) loupanPicService.getOnePicByUrl(urlList).getData()).get(0);
                map.put("Picture", loupanPicEntity);
                resultList.add(map);
            }
        }
        ResultVo resultVo = new ResultVo();
        resultVo.setData(resultList);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

    /**
     * 把infodata表的两层结构value，label，children返回到JSON文件中
     *
     * @return resultVo
     * @author litongzhe
     * @datetime 2019年3月26日21点08分
     */
    @GetMapping("/getAllData2Json")
    public void getAllData2Json() {
        InfodataEntity infodataEntity = new InfodataEntity();
        List<InfodataEntity> infodataEntities = (List<InfodataEntity>) infodataService.getCity().getData();
        List<Map> allData = new ArrayList<>();
        for (InfodataEntity e : infodataEntities) {
            Map<String, Object> cityInfo = Maps.newLinkedHashMap();
            String city = e.getCity();
            cityInfo.put("value", city);
            cityInfo.put("label", city);
            infodataEntity.setCity(city);
            List<InfodataEntity> regionEntities = (List<InfodataEntity>) infodataService.getRegion(infodataEntity).getData();
            List<Map> regions = new ArrayList<>();
            for (InfodataEntity regionEntity : regionEntities) {
                Map<String, Object> regionInfo = Maps.newLinkedHashMap();
                String region = regionEntity.getRegion();
                regionInfo.put("value", region);
                regionInfo.put("label", region);
                regions.add(regionInfo);
            }
            cityInfo.put("children", regions);
            allData.add(cityInfo);
        }
        Gson gson = new Gson();
        String str = gson.toJson(allData);
        BufferedWriter writer = null;
        File file = new File("d:\\allData.json");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "UTF-8"));
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 提供返回infodata表的两层结构value，label，children的接口
     *
     * @return resultVo
     * @author litongzhe
     */
    @GetMapping("/getAllData")
    public ResultVo getAllData() throws IOException {
        File directory = new File("");
        String courseFile = directory.getCanonicalPath();
        String path = courseFile + "/src/main/resources/model/allData.json";
        String jsonStr = "";
        try {
            File jsonFile = new File(path);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "UTF-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1)
                sb.append((char) ch);
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map> maps = null;
        maps = (List) JSONArray.fromObject(jsonStr);
        ResultVo resultVo = new ResultVo();
        resultVo.setData(maps);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

}
