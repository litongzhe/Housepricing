package com.raising.modules.userManager.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raising.framework.controller.BaseController;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;

import com.raising.modules.userManager.entity.UserEntity;
import com.raising.modules.userManager.service.UserService;

/**
 *  控制器
 * @author fsd
 * @createTime 2019-02-27 11:09:34
 */
@RestController
@RequestMapping("/userManager/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 分页 - 查询
     * @author fsd
     * @datetime 2019-02-27 11:09:34
     * @param page
     * @param user
     * @return ResultVo
     */
    // @RequiresPermissions("userManager:user:select")
    @GetMapping("/page")
    public ResultVo page(UserEntity user,Page<UserEntity> page) {
        page.setEntity(user);
        ResultVo resultVo = userService.getPage(page);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

    /**
     * 详情 - 查询
     * @author fsd
     * @datetime 2019-02-27 11:09:34
     * @param id 
     * @return ResultVo
     */
    // @RequiresPermissions("userManager:user:select")
    @GetMapping("/info")
    public ResultVo info(@RequestParam("id") String id) {
        return userService.get(id);
    }

    /**
     * 新增 - 插入
     * @author fsd
     * @datetime 2019-02-27 11:09:34
     * @param user
     * @return ResultVo
     */
    // @RequiresPermissions("userManager:user:insert")
    @PostMapping("/insert")
    public ResultVo insert(UserEntity user) {
        UserEntity insert = new UserEntity();
        //赋值至 insert 对象
        insert.setId(user.getId());
        insert.setName(user.getName());
        insert.setTel(user.getTel());
        insert.setPassword(user.getPassword());
        ResultVo resultVo = userService.insert(insert);
        resultVo.setData(insert.getId());
        return resultVo;
    }

    /**
     * 更新
     * @author fsd
     * @datetime 2019-02-27 11:09:34
     * @param user
     * @return ResultVo
     */
    // @RequiresPermissions("userManager:user:update")
    @PostMapping("/update")
    public ResultVo update(UserEntity user) {
        UserEntity update = new UserEntity();
        //赋值至 update 对象
        update.setId(user.getId());
        update.setName(user.getName());
        update.setTel(user.getTel());
        update.setPassword(user.getPassword());
        return userService.update(update);
    }

    /**
     * 删除
     * @author fsd
     * @datetime 2019-02-27 11:09:34
     * @param id 
     * @return ResultVo
     */
    // @RequiresPermissions("userManager:user:delete")
    @PostMapping("/delete")
    public ResultVo delete(@RequestParam("id") String id) {
        return userService.delete(id);
    }

}
