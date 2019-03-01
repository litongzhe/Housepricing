package com.raising.modules.cityInfo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raising.framework.controller.BaseController;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;

import com.raising.modules.cityInfo.entity.CityinfoEntity;
import com.raising.modules.cityInfo.service.CityinfoService;

/**
 *  控制器
 * @author chy
 * @createTime 2019-02-28 14:42:17
 */
@RestController
@RequestMapping("/cityInfo/cityinfo")
public class CityinfoController extends BaseController {

    @Autowired
    private CityinfoService cityinfoService;

    /**
     * 分页 - 查询
     * @author chy
     * @datetime 2019-02-28 14:42:17
     * @param page
     * @param cityinfo
     * @return ResultVo
     */
    // @RequiresPermissions("cityInfo:cityinfo:select")
    @GetMapping("/page")
    public ResultVo page(CityinfoEntity cityinfo,Page<CityinfoEntity> page) {
        page.setEntity(cityinfo);
        ResultVo resultVo = cityinfoService.getPage(page);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

    /**
     * 详情 - 查询
     * @author chy
     * @datetime 2019-02-28 14:42:17
     * @param id 
     * @return ResultVo
     */
    // @RequiresPermissions("cityInfo:cityinfo:select")
    @GetMapping("/info")
    public ResultVo info(@RequestParam("id") String id) {
        return cityinfoService.get(id);
    }

    /**
     * 新增 - 插入
     * @author chy
     * @datetime 2019-02-28 14:42:17
     * @param cityinfo
     * @return ResultVo
     */
    // @RequiresPermissions("cityInfo:cityinfo:insert")
    @PostMapping("/insert")
    public ResultVo insert(CityinfoEntity cityinfo) {
        CityinfoEntity insert = new CityinfoEntity();
        //赋值至 insert 对象
        insert.setDate(cityinfo.getDate());
        insert.setCity(cityinfo.getCity());
        insert.setXiaoqu(cityinfo.getXiaoqu());
        insert.setPrice(cityinfo.getPrice());
        insert.setTotal(cityinfo.getTotal());
        insert.setUrl(cityinfo.getUrl());
        insert.setPropertytype(cityinfo.getPropertytype());
        insert.setReferenceprice(cityinfo.getReferenceprice());
        insert.setProjectfeatures(cityinfo.getProjectfeatures());
        insert.setRegionallocation(cityinfo.getRegionallocation());
        insert.setPropertyaddress(cityinfo.getPropertyaddress());
        insert.setSalesofficeaddress(cityinfo.getSalesofficeaddress());
        insert.setDeveloper(cityinfo.getDeveloper());
        insert.setBuildingtype(cityinfo.getBuildingtype());
        insert.setLandscapingratio(cityinfo.getLandscapingratio());
        insert.setSitearea(cityinfo.getSitearea());
        insert.setFloorarearatio(cityinfo.getFloorarearatio());
        insert.setBuildingarea(cityinfo.getBuildingarea());
        insert.setYearofpropertyrights(cityinfo.getYearofpropertyrights());
        insert.setNumplan(cityinfo.getNumplan());
        insert.setPropertycompany(cityinfo.getPropertycompany());
        insert.setParkingratio(cityinfo.getParkingratio());
        insert.setPropertycosts(cityinfo.getPropertycosts());
        insert.setHeatingmethod(cityinfo.getHeatingmethod());
        insert.setWatersupplymethod(cityinfo.getWatersupplymethod());
        insert.setPowersupply(cityinfo.getPowersupply());
        insert.setParkingspace(cityinfo.getParkingspace());
        insert.setId(cityinfo.getId());
        ResultVo resultVo = cityinfoService.insert(insert);
        resultVo.setData(insert.getId());
        return resultVo;
    }

    /**
     * 更新
     * @author chy
     * @datetime 2019-02-28 14:42:17
     * @param cityinfo
     * @return ResultVo
     */
    // @RequiresPermissions("cityInfo:cityinfo:update")
    @PostMapping("/update")
    public ResultVo update(CityinfoEntity cityinfo) {
        CityinfoEntity update = new CityinfoEntity();
        //赋值至 update 对象
        update.setDate(cityinfo.getDate());
        update.setCity(cityinfo.getCity());
        update.setXiaoqu(cityinfo.getXiaoqu());
        update.setPrice(cityinfo.getPrice());
        update.setTotal(cityinfo.getTotal());
        update.setUrl(cityinfo.getUrl());
        update.setPropertytype(cityinfo.getPropertytype());
        update.setReferenceprice(cityinfo.getReferenceprice());
        update.setProjectfeatures(cityinfo.getProjectfeatures());
        update.setRegionallocation(cityinfo.getRegionallocation());
        update.setPropertyaddress(cityinfo.getPropertyaddress());
        update.setSalesofficeaddress(cityinfo.getSalesofficeaddress());
        update.setDeveloper(cityinfo.getDeveloper());
        update.setBuildingtype(cityinfo.getBuildingtype());
        update.setLandscapingratio(cityinfo.getLandscapingratio());
        update.setSitearea(cityinfo.getSitearea());
        update.setFloorarearatio(cityinfo.getFloorarearatio());
        update.setBuildingarea(cityinfo.getBuildingarea());
        update.setYearofpropertyrights(cityinfo.getYearofpropertyrights());
        update.setNumplan(cityinfo.getNumplan());
        update.setPropertycompany(cityinfo.getPropertycompany());
        update.setParkingratio(cityinfo.getParkingratio());
        update.setPropertycosts(cityinfo.getPropertycosts());
        update.setHeatingmethod(cityinfo.getHeatingmethod());
        update.setWatersupplymethod(cityinfo.getWatersupplymethod());
        update.setPowersupply(cityinfo.getPowersupply());
        update.setParkingspace(cityinfo.getParkingspace());
        update.setId(cityinfo.getId());
        return cityinfoService.update(update);
    }

    /**
     * 删除
     * @author chy
     * @datetime 2019-02-28 14:42:17
     * @param id 
     * @return ResultVo
     */
    // @RequiresPermissions("cityInfo:cityinfo:delete")
    @PostMapping("/delete")
    public ResultVo delete(@RequestParam("id") String id) {
        return cityinfoService.delete(id);
    }

}
