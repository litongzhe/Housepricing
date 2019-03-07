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

import javax.persistence.criteria.CriteriaBuilder;
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
        List<Map> priceList=new ArrayList<>();
        for (PricehistorynewEntity e : entitys) {
            Map<String, Object> priceMap = Maps.newLinkedHashMap();
            priceMap.put("time",e.getMouth());
            priceMap.put("price", Double.valueOf(e.getHouseprice()));
            priceList.add(priceMap);
        }
        resultMap.put("priceHistory", priceList);
        ResultVo resultVo = new ResultVo();
        resultVo.setData(resultMap);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

    /**
     * 房型
     *
     * @param city
     * @return ResultVo
     * @author litongzhe
     * @datetime 2019年3月6日16点26分
     */
    @GetMapping("/propertyType")
    public ResultVo propertyType(@RequestParam("city") String city){
        InfodataEntity infopt = new InfodataEntity();
        RegioninfoEntity regionpt = new RegioninfoEntity();
        regionpt.setCityname(city);

        List<RegioninfoEntity> regionentitys = (List<RegioninfoEntity>) regioninfoService.getList(regionpt).getData();
        List<String> regionName = new ArrayList<>();
        for(RegioninfoEntity e:regionentitys){
            regionName.add(e.getRegionname());
        }
        String properType[] = {"住宅","商业","写字楼","别墅","底商","酒店式公寓","公寓","商铺"};
        Map<String,List<Map>> regionInfo = Maps.newLinkedHashMap();//区域：信息
        infopt.setCity(city);
        List<InfodataEntity> infoentitys0 = (List<InfodataEntity>) infodataService.getList(infopt).getData();
        for(String region:regionName){//不同区域
//            infopt.setRegion(region);
            List<InfodataEntity> infoentitys1 = new ArrayList<>();
            for(InfodataEntity e:infoentitys0){
                if(e.getRegion().equals(region)){
                    infoentitys1.add(e);//同一区域
//                    infoentitys0.remove(e);
                }
            }
            List<Map> info = new ArrayList<>();
            for(int i = 0; i < 8; i++){//同一区域不同房型
//                infopt.setPropertytype(properType[i]);
                List<InfodataEntity> infoentitys2 = new ArrayList<>();//同一区域同一房型
                for(InfodataEntity e:infoentitys1){
                    if(e.getPropertytype().equals(properType[i])){
                        infoentitys2.add(e);
//                        infoentitys1.remove(e);
                    }
                }
                int num = 0;
                int price = 0;
                int numPlan = 0;
                Map<String,Object> typeInfo = Maps.newLinkedHashMap();
                for(InfodataEntity e:infoentitys2){
                    String strprice = e.getPrice();
                    String strnum = e.getNumplan();
                    if(strprice.equals("价格待定")){
                        price += 0;
                        num += 0;
                    }
                    else{
                        price += Double.valueOf(strprice);
                        num += 1;
                    }
                    if(strnum.equals("暂无信息")){
                        numPlan += 0;
                    }
                    else{
                        numPlan += Integer.valueOf(strnum);
                    }
                }
                if(num != 0)
                    price /= num;//平均房价
                typeInfo.put("Type",properType[i]);
                typeInfo.put("AvgPrice",price);
                typeInfo.put("numPlan",numPlan);
                info.add(typeInfo);
            }
            regionInfo.put(region,info);
        }
        ResultVo resultVo = new ResultVo();
        resultVo.setData(regionInfo);
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
            String strproportion = e.getProportion();
            String month = e.getMouth();
            String change = e.getInc2();
            Map<String, Object> proportionMap = Maps.newLinkedHashMap();

            if (strproportion.equals("--")) {
                proportionMap.put("time",month);
                proportionMap.put("proportion", 0.0);
            } else {
                double proportion = Double.valueOf(strproportion);
                if(change.equals("下降")){
                    proportion = -1*proportion;
                }
                proportionMap.put("time",month);
                proportionMap.put("proportion", proportion);
            }
            proportionList.add(proportionMap);
        }

        Map<String, Integer> regionPriceMap = Maps.newLinkedHashMap();
        for (RegioninfoEntity e : regionentitys) {
            regionPriceMap.put(e.getRegionname(), Integer.valueOf(e.getAvgprice()));
        }
        Map<String, Integer> regionNumMap = Maps.newLinkedHashMap();
        for (InfodataEntity e : infoentitys) {
            String region = e.getRegion();
            String strnum = e.getNumplan();
            if (strnum.equals("暂无信息"))
                continue;
            if (regionNumMap.containsKey(region)) {
                Integer num = regionNumMap.get(region) + Integer.valueOf(strnum);
                regionNumMap.put(region, num);
            } else {
                regionNumMap.put(region, Integer.valueOf(strnum));
            }
        }

        List<Map> regionList = new ArrayList<>();
        for(String key:regionPriceMap.keySet()){
            Map<String,Object> singleRegionInfo = Maps.newLinkedHashMap();
            singleRegionInfo.put("supply",regionNumMap.get(key));
            singleRegionInfo.put("price",regionPriceMap.get(key));
            singleRegionInfo.put("regionName",key);
            regionList.add(singleRegionInfo);
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("cityName", city);
        resultMap.put("cityLevel", citylevel);
        resultMap.put("cityAvgPrice", avgprice);
        resultMap.put("citySupplyNum", gongginum);
        resultMap.put("proportion", proportionList);
        resultMap.put("regionInfo", regionList);

        ResultVo resultVo = new ResultVo();
        resultVo.setData(resultMap);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }
}