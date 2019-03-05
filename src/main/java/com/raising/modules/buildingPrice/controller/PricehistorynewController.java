package com.raising.modules.buildingPrice.controller;

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

}
