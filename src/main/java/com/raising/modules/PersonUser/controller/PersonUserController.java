package com.raising.modules.PersonUser.controller;

import com.raising.modules.PersonUser.dao.PersonUserDao;
import com.raising.modules.PersonUser.service.MailService;
import com.raising.util.CodeUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raising.framework.controller.BaseController;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;

import com.raising.modules.PersonUser.entity.PersonUserEntity;
import com.raising.modules.PersonUser.service.PersonUserService;

import java.text.SimpleDateFormat;
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
        if(personUserService.findByUserEmail(email) == null){
            resultVo.setData("email have been registered!");
            return resultVo;
        }
        String emailEncode = CodeUtil.md5(email);
        personUserEntity.setId(emailEncode);
        personUserService.addUser(personUserEntity);
        resultVo.setData("add "+ personUserEntity.getEmail() +" success!");
        return resultVo;
    }

    @PostMapping("/login")
    public ResultVo userCheckMail(String email, String code) {

        PersonUserEntity pue = personUserService.findByUserId(code);
        if(pue == null) return null;
        if(pue.getEmail() != null && pue.getEmail().equals(email)) {
            pue.setStatus("1");
            ResultVo resultVo = personUserService.update(pue);
            resultVo.setData(pue.getId());
            return resultVo;

        }
        ResultVo resultVo = new ResultVo();
        resultVo.setData("邮件验证失败");
        return resultVo;
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
        resultVo.setCode(200);
        resultVo.setData(checkCode);
        return resultVo;
    }

}
