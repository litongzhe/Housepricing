package com.raising.modules.buildingPrice.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raising.framework.controller.BaseController;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;

import com.raising.modules.buildingPrice.entity.RegioninfoEntity;
import com.raising.modules.buildingPrice.service.RegioninfoService;

/**
 *  控制器
 * @author fsd
 * @createTime 2019-03-04 14:17:51
 */
@RestController
@RequestMapping("/buildingPrice/regioninfo")
public class RegioninfoController extends BaseController {

    @Autowired
    private RegioninfoService regioninfoService;

    /**
     * 分页 - 查询
     * @author fsd
     * @datetime 2019-03-04 14:17:51
     * @param page
     * @param regioninfo
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:regioninfo:select")
    @GetMapping("/page")
    public ResultVo page(RegioninfoEntity regioninfo,Page<RegioninfoEntity> page) {
        page.setEntity(regioninfo);
        ResultVo resultVo = regioninfoService.getPage(page);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

    /**
     * 详情 - 查询
     * @author fsd
     * @datetime 2019-03-04 14:17:51
     * @param id 
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:regioninfo:select")
    @GetMapping("/info")
    public ResultVo info(@RequestParam("id") String id) {
        return regioninfoService.get(id);
    }

    /**
     * 新增 - 插入
     * @author fsd
     * @datetime 2019-03-04 14:17:51
     * @param regioninfo
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:regioninfo:insert")
    @PostMapping("/insert")
    public ResultVo insert(RegioninfoEntity regioninfo) {
        RegioninfoEntity insert = new RegioninfoEntity();
        //赋值至 insert 对象
        insert.setId(regioninfo.getId());
        insert.setCityname(regioninfo.getCityname());
        insert.setRegionname(regioninfo.getRegionname());
        insert.setAvgprice(regioninfo.getAvgprice());
        insert.setLat(regioninfo.getLat());
        insert.setLng(regioninfo.getLng());
        ResultVo resultVo = regioninfoService.insert(insert);
        resultVo.setData(insert.getId());
        return resultVo;
    }

    /**
     * 更新
     * @author fsd
     * @datetime 2019-03-04 14:17:51
     * @param regioninfo
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:regioninfo:update")
    @PostMapping("/update")
    public ResultVo update(RegioninfoEntity regioninfo) {
        RegioninfoEntity update = new RegioninfoEntity();
        //赋值至 update 对象
        update.setId(regioninfo.getId());
        update.setCityname(regioninfo.getCityname());
        update.setRegionname(regioninfo.getRegionname());
        update.setAvgprice(regioninfo.getAvgprice());
        update.setLat(regioninfo.getLat());
        update.setLng(regioninfo.getLng());
        return regioninfoService.update(update);
    }

    /**
     * 删除
     * @author fsd
     * @datetime 2019-03-04 14:17:51
     * @param id 
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:regioninfo:delete")
    @PostMapping("/delete")
    public ResultVo delete(@RequestParam("id") String id) {
        return regioninfoService.delete(id);
    }

}
