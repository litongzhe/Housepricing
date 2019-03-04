package com.raising.modules.priceInfo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raising.framework.controller.BaseController;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;

import com.raising.modules.priceInfo.entity.InfodataEntity;
import com.raising.modules.priceInfo.service.InfodataService;

/**
 *  控制器
 * @author fsd
 * @createTime 2019-03-04 11:18:27
 */
@RestController
@RequestMapping("/priceInfo/infodata")
public class InfodataController extends BaseController {

    @Autowired
    private InfodataService infodataService;

    /**
     * 分页 - 查询
     * @author fsd
     * @datetime 2019-03-04 11:18:27
     * @param page
     * @param infodata
     * @return ResultVo
     */
    // @RequiresPermissions("priceInfo:infodata:select")
    @GetMapping("/page")
    public ResultVo page(InfodataEntity infodata,Page<InfodataEntity> page) {
        page.setEntity(infodata);
        ResultVo resultVo = infodataService.getPage(page);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

    /**
     * 详情 - 查询
     * @author fsd
     * @datetime 2019-03-04 11:18:27
     * @param id 
     * @return ResultVo
     */
    // @RequiresPermissions("priceInfo:infodata:select")
    @GetMapping("/info")
    public ResultVo info(@RequestParam("id") String id) {
        return infodataService.get(id);
    }

    /**
     * 新增 - 插入
     * @author fsd
     * @datetime 2019-03-04 11:18:27
     * @param infodata
     * @return ResultVo
     */
    // @RequiresPermissions("priceInfo:infodata:insert")
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
     * @author fsd
     * @datetime 2019-03-04 11:18:27
     * @param infodata
     * @return ResultVo
     */
    // @RequiresPermissions("priceInfo:infodata:update")
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
     * @author fsd
     * @datetime 2019-03-04 11:18:27
     * @param id 
     * @return ResultVo
     */
    // @RequiresPermissions("priceInfo:infodata:delete")
    @PostMapping("/delete")
    public ResultVo delete(@RequestParam("id") String id) {
        return infodataService.delete(id);
    }

}
