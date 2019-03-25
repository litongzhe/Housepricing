package com.raising.modules.buildingPrice.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raising.framework.controller.BaseController;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;

import com.raising.modules.buildingPrice.entity.LoupanPicEntity;
import com.raising.modules.buildingPrice.service.LoupanPicService;

/**
 *  控制器
 * @author fsd
 * @createTime 2019-03-20 14:38:23
 */
@RestController
@RequestMapping("/buildingPrice/loupanPic")
public class LoupanPicController extends BaseController {

    @Autowired
    private LoupanPicService loupanPicService;

    /**
     * 分页 - 查询
     * @author fsd
     * @datetime 2019-03-20 14:38:23
     * @param page
     * @param loupanPic
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:loupanPic:select")
    @GetMapping("/page")
    public ResultVo page(LoupanPicEntity loupanPic,Page<LoupanPicEntity> page) {
        page.setEntity(loupanPic);
        ResultVo resultVo = loupanPicService.getPage(page);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

    /**
     * 详情 - 查询
     * @author fsd
     * @datetime 2019-03-20 14:38:23
     * @param id 
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:loupanPic:select")
    @GetMapping("/info")
    public ResultVo info(@RequestParam("id") String id) {
        return loupanPicService.get(id);
    }

    /**
     * 新增 - 插入
     * @author fsd
     * @datetime 2019-03-20 14:38:23
     * @param loupanPic
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:loupanPic:insert")
    @PostMapping("/insert")
    public ResultVo insert(LoupanPicEntity loupanPic) {
        LoupanPicEntity insert = new LoupanPicEntity();
        //赋值至 insert 对象
        insert.setId(loupanPic.getId());
        insert.setNum(loupanPic.getNum());
        insert.setUrl(loupanPic.getUrl());
        insert.setType(loupanPic.getType());
        insert.setPic(loupanPic.getPic());
        ResultVo resultVo = loupanPicService.insert(insert);
        resultVo.setData(insert.getId());
        return resultVo;
    }

    /**
     * 更新
     * @author fsd
     * @datetime 2019-03-20 14:38:23
     * @param loupanPic
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:loupanPic:update")
    @PostMapping("/update")
    public ResultVo update(LoupanPicEntity loupanPic) {
        LoupanPicEntity update = new LoupanPicEntity();
        //赋值至 update 对象
        update.setId(loupanPic.getId());
        update.setNum(loupanPic.getNum());
        update.setUrl(loupanPic.getUrl());
        update.setType(loupanPic.getType());
        update.setPic(loupanPic.getPic());
        return loupanPicService.update(update);
    }

    /**
     * 删除
     * @author fsd
     * @datetime 2019-03-20 14:38:23
     * @param id 
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:loupanPic:delete")
    @PostMapping("/delete")
    public ResultVo delete(@RequestParam("id") String id) {
        return loupanPicService.delete(id);
    }

}
