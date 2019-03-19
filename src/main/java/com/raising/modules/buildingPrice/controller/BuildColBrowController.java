package com.raising.modules.buildingPrice.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raising.framework.controller.BaseController;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;

import com.raising.modules.buildingPrice.entity.BuildColBrowEntity;
import com.raising.modules.buildingPrice.service.BuildColBrowService;

/**
 *  控制器
 * @author fsd
 * @createTime 2019-03-18 16:09:58
 */
@RestController
@RequestMapping("/buildingPrice/buildColBrow")
public class BuildColBrowController extends BaseController {

    @Autowired
    private BuildColBrowService buildColBrowService;

    /**
     * 分页 - 查询
     * @author fsd
     * @datetime 2019-03-18 16:09:58
     * @param page
     * @param buildColBrow
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:buildColBrow:select")
    @GetMapping("/page")
    public ResultVo page(BuildColBrowEntity buildColBrow,Page<BuildColBrowEntity> page) {
        page.setEntity(buildColBrow);
        ResultVo resultVo = buildColBrowService.getPage(page);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

    /**
     * 详情 - 查询
     * @author fsd
     * @datetime 2019-03-18 16:09:58
     * @param xiaoquid 小区的id号对应infodata的id
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:buildColBrow:select")
    @GetMapping("/info")
    public ResultVo info(@RequestParam("xiaoquid") String xiaoquid) {
        return buildColBrowService.get(xiaoquid);
    }

    /**
     * 新增 - 插入
     * @author fsd
     * @datetime 2019-03-18 16:09:58
     * @param buildColBrow
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:buildColBrow:insert")
    @PostMapping("/insert")
    public ResultVo insert(BuildColBrowEntity buildColBrow) {
        BuildColBrowEntity insert = new BuildColBrowEntity();
        //赋值至 insert 对象
        insert.setXiaoquid(buildColBrow.getXiaoquid());
        insert.setCollectnum(buildColBrow.getCollectnum());
        insert.setBrowsenum(buildColBrow.getBrowsenum());
        ResultVo resultVo = buildColBrowService.insert(insert);
        resultVo.setData(insert.getXiaoquid());
        return resultVo;
    }

    /**
     * 更新
     * @author fsd
     * @datetime 2019-03-18 16:09:58
     * @param buildColBrow
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:buildColBrow:update")
    @PostMapping("/update")
    public ResultVo update(BuildColBrowEntity buildColBrow) {
        BuildColBrowEntity update = new BuildColBrowEntity();
        //赋值至 update 对象
        update.setXiaoquid(buildColBrow.getXiaoquid());
        update.setCollectnum(buildColBrow.getCollectnum());
        update.setBrowsenum(buildColBrow.getBrowsenum());
        return buildColBrowService.update(update);
    }

    /**
     * 删除
     * @author fsd
     * @datetime 2019-03-18 16:09:58
     * @param xiaoquid 小区的id号对应infodata的id
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:buildColBrow:delete")
    @PostMapping("/delete")
    public ResultVo delete(@RequestParam("xiaoquid") String xiaoquid) {
        return buildColBrowService.delete(xiaoquid);
    }

}
