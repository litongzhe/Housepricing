package com.raising.modules.PersonUser.controller;

import com.raising.framework.entity.ResultCode;
import com.raising.framework.shiro.util.JWTUtil;
import com.raising.modules.PersonUser.service.MailService;
import com.raising.modules.operationlog.annotation.OperationLog;
import com.raising.modules.sys.entity.User;
import com.raising.util.CodeUtil;
import com.raising.util.PersonUserUtils;
import com.raising.utils.PasswordUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raising.framework.controller.BaseController;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;

import com.raising.modules.PersonUser.entity.PersonUserEntity;
import com.raising.modules.PersonUser.service.PersonUserService;

import java.util.Date;
import java.util.Random;

/**
 * 用户表 控制器
 * @author fsd
 * @createTime 2019-02-28 16:06:42
 */
@RestController
@RequestMapping("/PersonUser/personUser")
public class PersonUserController extends BaseController {

    @Autowired
    private PersonUserService personUserService;

    @Autowired
    private MailService mailService;

    @Autowired
    private PasswordUtils passwordUtils;
    /**
     * 分页 - 查询
     * @author fsd
     * @datetime 2019-02-28 16:06:42
     * @param page
     * @param personUser
     * @return ResultVo
     */
    // @RequiresPermissions("PersonUser:personUser:select")
    @GetMapping("/page")
    public ResultVo page(PersonUserEntity personUser,Page<PersonUserEntity> page) {
        page.setEntity(personUser);
        ResultVo resultVo = personUserService.getPage(page);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

    /**
     * 详情 - 查询
     * @author fsd
     * @datetime 2019-02-28 16:06:42
     * @param id 主键，自增
     * @return ResultVo
     */
    // @RequiresPermissions("PersonUser:personUser:select")
    @GetMapping("/info")
    public ResultVo info(@RequestParam("id") String id) {
        return personUserService.get(id);
    }

    /**
     * 新增 - 插入
     * @author fsd
     * @datetime 2019-02-28 16:06:42
     * @param personUser
     * @return ResultVo
     */
    // @RequiresPermissions("PersonUser:personUser:insert")
    @PostMapping("/insert")
    public ResultVo insert(PersonUserEntity personUser) {
        PersonUserEntity insert = new PersonUserEntity();
        //赋值至 insert 对象
        insert.setId(personUser.getId());
        insert.setNo(personUser.getNo());
        insert.setOrganizationId(personUser.getOrganizationId());
        insert.setManageOrgIds(personUser.getManageOrgIds());
        insert.setUsername(personUser.getUsername());
        insert.setPassword(personUser.getPassword());
        insert.setSalt(personUser.getSalt());
        insert.setRoleIds(personUser.getRoleIds());
        insert.setName(personUser.getName());
        insert.setEmail(personUser.getEmail());
        insert.setPhone(personUser.getPhone());
        insert.setPhoto(personUser.getPhoto());
        insert.setStationNm(personUser.getStationNm());
        insert.setLoginIp(personUser.getLoginIp());
        insert.setLoginDate(personUser.getLoginDate());
        insert.setIsOff(personUser.getIsOff());
        insert.setLocked(personUser.getLocked());
        insert.setIsDept(personUser.getIsDept());
        insert.setPhoneDeviceId(personUser.getPhoneDeviceId());
        insert.setBalance(personUser.getBalance());
        insert.setUserTypeCd(personUser.getUserTypeCd());
        insert.setSexCd(personUser.getSexCd());
        insert.setRemarks(personUser.getRemarks());
        insert.setCreateBy(personUser.getCreateBy());
        insert.setCreateDate(personUser.getCreateDate());
        insert.setUpdateBy(personUser.getUpdateBy());
        insert.setUpdateDate(personUser.getUpdateDate());
        insert.setStatus(personUser.getStatus());
        ResultVo resultVo = personUserService.insert(insert);
        resultVo.setData(insert.getId());
        return resultVo;
    }

    /**
     * 更新
     * @author fsd
     * @datetime 2019-02-28 16:06:42
     * @param personUser
     * @return ResultVo
     */
    // @RequiresPermissions("PersonUser:personUser:update")
    @PostMapping("/update")
    public ResultVo update(PersonUserEntity personUser) {
        PersonUserEntity update = new PersonUserEntity();
        //赋值至 update 对象
        update.setId(personUser.getId());
        update.setNo(personUser.getNo());
        update.setOrganizationId(personUser.getOrganizationId());
        update.setManageOrgIds(personUser.getManageOrgIds());
        update.setUsername(personUser.getUsername());
        update.setPassword(personUser.getPassword());
        update.setSalt(personUser.getSalt());
        update.setRoleIds(personUser.getRoleIds());
        update.setName(personUser.getName());
        update.setEmail(personUser.getEmail());
        update.setPhone(personUser.getPhone());
        update.setPhoto(personUser.getPhoto());
        update.setStationNm(personUser.getStationNm());
        update.setLoginIp(personUser.getLoginIp());
        update.setLoginDate(personUser.getLoginDate());
        update.setIsOff(personUser.getIsOff());
        update.setLocked(personUser.getLocked());
        update.setIsDept(personUser.getIsDept());
        update.setPhoneDeviceId(personUser.getPhoneDeviceId());
        update.setBalance(personUser.getBalance());
        update.setUserTypeCd(personUser.getUserTypeCd());
        update.setSexCd(personUser.getSexCd());
        update.setRemarks(personUser.getRemarks());
        update.setCreateBy(personUser.getCreateBy());
        update.setCreateDate(personUser.getCreateDate());
        update.setUpdateBy(personUser.getUpdateBy());
        update.setUpdateDate(personUser.getUpdateDate());
        update.setStatus(personUser.getStatus());
        return personUserService.update(update);
    }

    /**
     * 删除
     * @author fsd
     * @datetime 2019-02-28 16:06:42
     * @param id 主键，自增
     * @return ResultVo
     */
    // @RequiresPermissions("PersonUser:personUser:delete")
    @PostMapping("/delete")
    public ResultVo delete(@RequestParam("id") String id) {
        return personUserService.delete(id);
    }


    @PostMapping("/register")
    public ResultVo register(PersonUserEntity personUserEntity) {
        ResultVo resultVo = new ResultVo();
        String email = personUserEntity.getEmail();
//        String password_view = personUserEntity.getPassword();

        if(personUserService.findByUserEmail(email) == null){
            resultVo.setData("email have been registered!");
            return resultVo;
        }
        //编码生成ID 和 密码 并插入
        String IDFromEmail = CodeUtil.md5(email);
//        String passwordInDB = CodeUtil.md5(password_view);
        personUserEntity.setId(IDFromEmail);

//        personUserEntity.setPassword(passwordInDB);
//        personUserEntity.preInsert(UserUtils.getCurrentUser().getId());
        //插入新用户数据
        personUserService.addUser(personUserEntity);
        //生成token
//        String token = JWTUtil.sign(email, password_view);
        //返回前端信息
//        resultVo.setCode(200);
//        resultVo.setMsg("add "+ personUserEntity.getEmail() +" success!");
//        resultVo.setData(token);
        return new ResultVo(ResultCode.OK, personUserEntity.getId());
    }

    @PostMapping({"/login"})
    @OperationLog("登录")
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam(value = "site",required = false) String site) throws Exception {
        PersonUserEntity personUserEntity = this.personUserService.findByUserName(username);
        if (personUserEntity == null) {
            return (new ResultVo(ResultCode.EMPTY_ROW)).desc("用户不存在");
        } else if (personUserEntity.getPassword().equals(this.passwordUtils.getPassword(password, personUserEntity.getSalt()))) {
            String tokenKey = username + "-" + personUserEntity.getId() + "-" + personUserEntity.getUserTypeCd();
            return new ResultVo(ResultCode.OK, JWTUtil.sign(tokenKey, personUserEntity.getPassword()));
        } else {
            throw new UnauthorizedException();
        }
    }

    @GetMapping({"check"})
    @OperationLog("执行检查用户是否登录")
    public ResultVo check() {
        this.operationlog("测试log", "{username:123}");
        Subject subject = SecurityUtils.getSubject();
        return subject.isAuthenticated() ? new ResultVo(ResultCode.OK) : new ResultVo(ResultCode.USER_NOT_LOGIN);
    }

    @GetMapping({"/logout"})
    @OperationLog("退出登录")
    @RequiresPermissions({"123"})
    public ResultVo logout() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            currentUser.logout();
            return new ResultVo(ResultCode.OK);
        } else {
            return new ResultVo(ResultCode.OK);
        }
    }

    @GetMapping({"/current_user"})
    @OperationLog("获取当前用户信息")
    @RequiresAuthentication
    public Object currentUser() {
        if (!PersonUserUtils.isLogin()) {
            return null;
        } else {
            PersonUserEntity pue = PersonUserUtils.getCurrentUser();
            return new ResultVo(ResultCode.OK, pue);
        }
    }



    @RequestMapping("/getCheckCode")
    @ResponseBody
    public ResultVo getCheckCode(@RequestParam("email") String email){
        ResultVo resultVo = new ResultVo();
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为："+checkCode;
        try {
            mailService.sendSimpleMail(email, "GDK房价预测系统注册验证码", message);
        }catch (Exception e){
            System.out.println(e);
            resultVo.setCode(555);
            return resultVo;
        }
        return new ResultVo(ResultCode.OK, checkCode);
    }

}
