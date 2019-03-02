package com.raising.modules.buildingInfo.controller;

import com.raising.framework.controller.BaseController;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;
import com.raising.modules.buildingInfo.entity.BuildinginfoEntity;
import com.raising.modules.buildingInfo.service.BuildinginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  控制器
 * @author fsd
 * @createTime 2019-02-26 15:27:23
 */
@RestController
@RequestMapping("/buildingInfo/buildinginfo")
public class BuildinginfoController11 extends BaseController {

    @Autowired
    private BuildinginfoService buildinginfoService;

    /**
     * 分页 - 查询暗示大神大多所
     * @author fsd
     * @datetime 2019-02-26 15:27:23
     * @param page
     * @param buildinginfo
     * @return ResultVo
     */
    // @RequiresPermissions("buildingInfo:buildinginfo:select")
    @GetMapping("/page")
    public ResultVo page(BuildinginfoEntity buildinginfo,Page<BuildinginfoEntity> page) {
        page.setEntity(buildinginfo);
        ResultVo resultVo = buildinginfoService.getPage(page);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

    /**
     * 详情 - 查询
     * @author fsd
     * @datetime 2019-02-26 15:27:23
     * @param id 
     * @return ResultVo
     */
    // @RequiresPermissions("buildingInfo:buildinginfo:select")
    @GetMapping("/info")
    public ResultVo info(@RequestParam("id") String id) {
        return buildinginfoService.get(id);
    }

    /**
     * 新增 - 插入
     * @author fsd
     * @datetime 2019-02-26 15:27:23
     * @param buildinginfo
     * @return ResultVo
     */
    // @RequiresPermissions("buildingInfo:buildinginfo:insert")
    @PostMapping("/insert")
    public ResultVo insert(BuildinginfoEntity buildinginfo) {
        BuildinginfoEntity insert = new BuildinginfoEntity();
        //赋值至 insert 对象
        insert.setId(buildinginfo.getId());
        insert.setLoupanname(buildinginfo.getLoupanname());
        insert.setPrice(buildinginfo.getPrice());
        insert.setLocation(buildinginfo.getLocation());
        ResultVo resultVo = buildinginfoService.insert(insert);
        resultVo.setData(insert.getId());
        return resultVo;
    }

    /**
     * 更新
     * @author fsd
     * @datetime 2019-02-26 15:27:23
     * @param buildinginfo
     * @return ResultVo
     */
    // @RequiresPermissions("buildingInfo:buildinginfo:update")
    @PostMapping("/update")
    public ResultVo update(BuildinginfoEntity buildinginfo) {
        BuildinginfoEntity update = new BuildinginfoEntity();
        //赋值至 update 对象
        update.setId(buildinginfo.getId());
        update.setLoupanname(buildinginfo.getLoupanname());
        update.setPrice(buildinginfo.getPrice());
        update.setLocation(buildinginfo.getLocation());
        return buildinginfoService.update(update);
    }

    /**
     * 删除
     * @author fsd
     * @datetime 2019-02-26 15:27:23
     * @param id 
     * @return ResultVo
     */
    // @RequiresPermissions("buildingInfo:buildinginfo:delete")
    @PostMapping("/delete")
    public ResultVo delete(@RequestParam("id") String id) {
        return buildinginfoService.delete(id);
    }

}
