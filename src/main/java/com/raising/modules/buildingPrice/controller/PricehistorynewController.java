package com.raising.modules.buildingPrice.controller;

import com.google.common.collect.Maps;
import com.raising.modules.buildingPrice.entity.InfodataEntity;
import com.raising.modules.buildingPrice.entity.RegioninfoEntity;
import com.raising.modules.buildingPrice.service.InfodataService;
import com.raising.modules.buildingPrice.service.RegioninfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raising.framework.controller.BaseController;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;

import com.raising.modules.buildingPrice.entity.PricehistorynewEntity;
import com.raising.modules.buildingPrice.service.PricehistorynewService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author fsd
 * @createTime 2019-03-05 11:09:22
 */
@RestController
@RequestMapping("/buildingPrice/pricehistorynew")
public class PricehistorynewController extends BaseController {

    @Autowired
    private PricehistorynewService pricehistorynewService;
    @Autowired
    private RegioninfoService regioninfoService;
    @Autowired
    private InfodataService infodataService;

    /**
     * 分页 - 查询
     *
     * @param page
     * @param pricehistorynew
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-05 11:09:22
     */
    // @RequiresPermissions("buildingPrice:pricehistorynew:select")
    @GetMapping("/page")
    public ResultVo page(PricehistorynewEntity pricehistorynew, Page<PricehistorynewEntity> page) {
        page.setEntity(pricehistorynew);
        ResultVo resultVo = pricehistorynewService.getPage(page);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

    /**
     * 详情 - 查询
     *
     * @param pricehistoryid
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-05 11:09:22
     */
    // @RequiresPermissions("buildingPrice:pricehistorynew:select")
    @GetMapping("/info")
    public ResultVo info(@RequestParam("pricehistoryid") String pricehistoryid) {
        return pricehistorynewService.get(pricehistoryid);
    }

    /**
     * 新增 - 插入
     *
     * @param pricehistorynew
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-05 11:09:22
     */
    // @RequiresPermissions("buildingPrice:pricehistorynew:insert")
    @PostMapping("/insert")
    public ResultVo insert(PricehistorynewEntity pricehistorynew) {
        PricehistorynewEntity insert = new PricehistorynewEntity();
        //赋值至 insert 对象
        insert.setYear(pricehistorynew.getYear());
        insert.setMouth(pricehistorynew.getMouth());
        insert.setProvince(pricehistorynew.getProvince());
        insert.setCity(pricehistorynew.getCity());
        insert.setCitylevel(pricehistorynew.getCitylevel());
        insert.setLongitude(pricehistorynew.getLongitude());
        insert.setTwist(pricehistorynew.getTwist());
        insert.setHouseprice(pricehistorynew.getHouseprice());
        insert.setProportion(pricehistorynew.getProportion());
        insert.setInc(pricehistorynew.getInc());
        insert.setInc2(pricehistorynew.getInc2());
        insert.setPricehistoryid(pricehistorynew.getPricehistoryid());
        ResultVo resultVo = pricehistorynewService.insert(insert);
        resultVo.setData(insert.getPricehistoryid());
        return resultVo;
    }

    /**
     * 更新
     *
     * @param pricehistorynew
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-05 11:09:22
     */
    // @RequiresPermissions("buildingPrice:pricehistorynew:update")
    @PostMapping("/update")
    public ResultVo update(PricehistorynewEntity pricehistorynew) {
        PricehistorynewEntity update = new PricehistorynewEntity();
        //赋值至 update 对象
        update.setYear(pricehistorynew.getYear());
        update.setMouth(pricehistorynew.getMouth());
        update.setProvince(pricehistorynew.getProvince());
        update.setCity(pricehistorynew.getCity());
        update.setCitylevel(pricehistorynew.getCitylevel());
        update.setLongitude(pricehistorynew.getLongitude());
        update.setTwist(pricehistorynew.getTwist());
        update.setHouseprice(pricehistorynew.getHouseprice());
        update.setProportion(pricehistorynew.getProportion());
        update.setInc(pricehistorynew.getInc());
        update.setInc2(pricehistorynew.getInc2());
        update.setPricehistoryid(pricehistorynew.getPricehistoryid());
        return pricehistorynewService.update(update);
    }

    /**
     * 删除
     *
     * @param pricehistoryid
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-05 11:09:22
     */
    // @RequiresPermissions("buildingPrice:pricehistorynew:delete")
    @PostMapping("/delete")
    public ResultVo delete(@RequestParam("pricehistoryid") String pricehistoryid) {
        return pricehistorynewService.delete(pricehistoryid);
    }

    @GetMapping("/citypricehistory")
    public ResultVo priceHistoryByCity(@RequestParam("city") String city) {
        PricehistorynewEntity phe = new PricehistorynewEntity();
        phe.setCity(city);
        List<PricehistorynewEntity> entitys = (List<PricehistorynewEntity>) pricehistorynewService.getList(phe).getData();

        Map<String, Object> resultMap = new HashMap<>();

        String cityName = entitys.get(0).getCity();
        resultMap.put("cityName", cityName);
        Map<String, Double> priceMap = Maps.newLinkedHashMap();
        for (PricehistorynewEntity e : entitys) {
            priceMap.put(e.getMouth(), Double.valueOf(e.getHouseprice()));
        }
        resultMap.put("priceHistory", priceMap);
        ResultVo resultVo = new ResultVo();
        resultVo.setData(resultMap);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }


    /**
     * 城市名，城市等级，城市平均房价，城市供给量，区房价变化率，区房价变化方向，区平均房价，区供给量
     *
     * @param city
     * @return ResultVo
     * @author litongzhe
     * @datetime 2019-03-05 20:48:22
     */
    @GetMapping("/citypriceInfo")
    public ResultVo citypriceInfo(@RequestParam("city") String city) {
        PricehistorynewEntity historycpi = new PricehistorynewEntity();
        RegioninfoEntity regioncpi = new RegioninfoEntity();
        InfodataEntity infocpi = new InfodataEntity();

        historycpi.setCity(city);
        regioncpi.setCityname(city);
        infocpi.setCity(city);

        List<PricehistorynewEntity> historyentitys = (List<PricehistorynewEntity>) pricehistorynewService.getList(historycpi).getData();
        String citylevel = historyentitys.get(0).getCitylevel();

        List<RegioninfoEntity> regionentitys = (List<RegioninfoEntity>) regioninfoService.getList(regioncpi).getData();
        double avgprice = 0.0;
        Integer regionnum = 0;
        for (RegioninfoEntity e : regionentitys) {
            avgprice += Double.valueOf(e.getAvgprice());
            regionnum++;
        }
        avgprice = avgprice / regionnum;

        List<InfodataEntity> infoentitys = (List<InfodataEntity>) infodataService.getList(infocpi).getData();
        Integer gongginum = 0;
        for (InfodataEntity e : infoentitys) {
            String num = e.getNumplan();
            if (num.equals("暂无信息"))
                continue;
            gongginum += Integer.valueOf(num);
        }
        List<Map> proportionList = new ArrayList<>();
        List<Map> changeList = new ArrayList<>();

        for (PricehistorynewEntity e : historyentitys) {
            String proportion = e.getProportion();
            Map<String, Double> proportionMap = Maps.newLinkedHashMap();
            Map<String, String> changeMap = Maps.newLinkedHashMap();
            if (proportion.equals("--")) {
                proportionMap.put(e.getMouth(), 0.0);
            } else {
                proportionMap.put(e.getMouth(), Double.valueOf(e.getProportion()));
            }
            changeMap.put(e.getMouth(), e.getInc2());
            proportionList.add(proportionMap);
            changeList.add(changeMap);
        }
        List<Map> regionList = new ArrayList<>();
        Map<String, Integer> regionPriceMap = Maps.newLinkedHashMap();
        for (RegioninfoEntity e : regionentitys) {

            regionPriceMap.put(e.getRegionname(), Integer.valueOf(e.getAvgprice()));
//            regionList.add(regionPriceMap);
        }
        Map<String, Integer> regionInfoMap = Maps.newLinkedHashMap();
        for (InfodataEntity e : infoentitys) {

            String region = e.getRegion();
            String strnum = e.getNumplan();

            if (strnum.equals("暂无信息"))
                continue;
            if (regionInfoMap.containsKey(region)) {

                Integer num = regionInfoMap.get(region) + Integer.valueOf(strnum);
                regionInfoMap.put(region, num);


            } else {
//                System.out.println(region);
//                int regionPrice=regionPriceMap.get(region);
//                System.out.println(regionPrice);
                regionInfoMap.put(region, Integer.valueOf(strnum));
//                regionInfoMap.put(region,regionPrice);

            }
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("cityName", city);
        resultMap.put("cityLevel", citylevel);
        resultMap.put("cityAvgPrice", avgprice);
        resultMap.put("citySupplyNum", gongginum);
        resultMap.put("proportion", proportionList);
        resultMap.put("change", changeList);
//        resultMap.put("regionPrice", regionPriceMap);
//        resultMap.put("regionSupply", regionSupplyMap);
        resultMap.put("regionInfo", regionList);

        ResultVo resultVo = new ResultVo();
        resultVo.setData(resultMap);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }
}
