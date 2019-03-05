package com.raising.modules.buildingPrice.controller;

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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  控制器
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
     * @author fsd
     * @datetime 2019-03-05 11:09:22
     * @param page
     * @param pricehistorynew
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:pricehistorynew:select")
    @GetMapping("/page")
    public ResultVo page(PricehistorynewEntity pricehistorynew,Page<PricehistorynewEntity> page) {
        page.setEntity(pricehistorynew);
        ResultVo resultVo = pricehistorynewService.getPage(page);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

    /**
     * 详情 - 查询
     * @author fsd
     * @datetime 2019-03-05 11:09:22
     * @param pricehistoryid 
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:pricehistorynew:select")
    @GetMapping("/info")
    public ResultVo info(@RequestParam("pricehistoryid") String pricehistoryid) {
        return pricehistorynewService.get(pricehistoryid);
    }

    /**
     * 新增 - 插入
     * @author fsd
     * @datetime 2019-03-05 11:09:22
     * @param pricehistorynew
     * @return ResultVo
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
     * @author fsd
     * @datetime 2019-03-05 11:09:22
     * @param pricehistorynew
     * @return ResultVo
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
     * @author fsd
     * @datetime 2019-03-05 11:09:22
     * @param pricehistoryid 
     * @return ResultVo
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
        List<PricehistorynewEntity> entitys = (List<PricehistorynewEntity>)pricehistorynewService.getList(phe).getData();

        Map<String,Object> resultMap = new HashMap<>();

        String cityName = entitys.get(0).getCity();
        resultMap.put("cityName",cityName);
        Map<String,Double> priceMap = new HashMap<>();
        for(PricehistorynewEntity e:entitys){
            priceMap.put(e.getMouth(),Double.valueOf(e.getHouseprice()));
        }
        resultMap.put("priceHistory",priceMap);
        ResultVo resultVo = new ResultVo();
        resultVo.setData(resultMap);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }


    /**
     * 城市名，城市等级，城市平均房价，城市供给量，区房价变化率，区房价变化方向，区平均房价，区供给量
     * @author litongzhe
     * @datetime 2019-03-05 20:48:22
     * @param city
     * @return ResultVo
     */
    @GetMapping("/citypriceInfo")
    public ResultVo citypriceInfo(@RequestParam("city") String city){
        PricehistorynewEntity historycpi = new PricehistorynewEntity();
        RegioninfoEntity regioncpi = new RegioninfoEntity();
        InfodataEntity infocpi = new InfodataEntity();

        historycpi.setCity(city);
        regioncpi.setCityname(city);
        infocpi.setCity(city);

        List<PricehistorynewEntity> historyentitys = (List<PricehistorynewEntity>)pricehistorynewService.getList(historycpi).getData();
        String citylevel = historyentitys.get(0).getCitylevel();

        List<RegioninfoEntity> regionentitys = (List<RegioninfoEntity>)regioninfoService.getList(regioncpi).getData();
        double avgprice = 0.0;
        Integer regionnum = 0;
        for(RegioninfoEntity e:regionentitys){
            avgprice += Double.valueOf(e.getAvgprice());
            regionnum++;
        }
        avgprice = avgprice/regionnum;

        List<InfodataEntity> infoentitys = (List<InfodataEntity>)infodataService.getList(infocpi).getData();
        Integer gongginum = 0;
        for(InfodataEntity e:infoentitys){
            String num = e.getNumplan();
            if(num.equals("暂无信息"))
                continue;
            gongginum += Integer.valueOf(num);
        }

        Map<String,Double> proportionMap = new HashMap<>();
        Map<String,String> changeMap = new HashMap<>();
        for(PricehistorynewEntity e:historyentitys){
            String proportion = e.getProportion();
            if(proportion.equals("--")){
                proportionMap.put(e.getMouth(),0.0);
            }
            else{
                proportionMap.put(e.getMouth(),Double.valueOf(e.getProportion()));
            }
            changeMap.put(e.getMouth(),e.getInc2());
        }

        Map<String,Integer> regionPriceMap = new HashMap<>();
        for(RegioninfoEntity e:regionentitys){
            regionPriceMap.put(e.getRegionname(),Integer.valueOf(e.getAvgprice()));
        }

        Map<String,Integer> regionSupplyMap = new HashMap<>();
        for(InfodataEntity e:infoentitys){
            String region = e.getRegion();
            String strnum = e.getNumplan();
            if(strnum.equals("暂无信息"))
                continue;
            if(regionSupplyMap.containsKey(region)){
                Integer num = regionSupplyMap.get(region) + Integer.valueOf(strnum);
                regionSupplyMap.put(region,num);
            }
            else {
                regionSupplyMap.put(region,Integer.valueOf(strnum));
            }
        }

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("cityName",city);
        resultMap.put("cityLevel",citylevel);
        resultMap.put("cityAvgPrice",avgprice);
        resultMap.put("citySupplyNum",gongginum);
        resultMap.put("proportion",proportionMap);
        resultMap.put("change",changeMap);
        resultMap.put("regionPrice",regionPriceMap);
        resultMap.put("regionSupply",regionSupplyMap);


        ResultVo resultVo = new ResultVo();
        resultVo.setData(resultMap);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }
}
