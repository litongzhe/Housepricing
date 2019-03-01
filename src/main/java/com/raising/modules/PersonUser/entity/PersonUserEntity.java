package com.raising.modules.PersonUser.entity;

import com.raising.framework.entity.BaseEntity;
import com.raising.modules.sys.entity.BaseSysEntity;

import java.util.Date;

/**
* 用户表
* @author fsd
* @createTime 2019-02-28 16:06:42
*/
public class PersonUserEntity extends BaseEntity<PersonUserEntity> {

    /** 主键，自增 */
    private String id;
    /** 用户编号（身份证） */
    private String no;
    /** 机构编号 */
    private String organizationId;
    /** 授权管理机构 */
    private String manageOrgIds;
    /** 账号 */
    private String username;
    /** 密码 */
    private String password;
    /** 加密盐 */
    private String salt;
    /** 权限编号集合 */
    private String roleIds;
    /** 姓名 */
    private String name;
    /** 邮箱 */
    private String email;
    /** 电话号码 */
    private String phone;
    /** 头像 */
    private String photo;
    /** 岗位 */
    private String stationNm;
    /** 登录IP */
    private String loginIp;
    /** 登录时间 */
    private String loginDate;
    /** 是否退伍 */
    private String isOff;
    /** 是否锁定 */
    private String locked;
    /** 是否部门管理员 */
    private String isDept;
    /** 手机设备号：唯一 */
    private String phoneDeviceId;
    /** 余额 */
    private String balance;
    /** 用户类型 */
    private String userTypeCd;
    /** 性别 */
    private String sexCd;
    /** 备注 */
    private String remarks;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    private String createDate;
    /** 修改者 */
    private String updateBy;
    /** 修改时间 */
    private String updateDate;
    /** 状态 */
    private String status;

    public PersonUserEntity() {}

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getNo(){
        return no;
    }

    public void setNo(String no){
        this.no = no;
    }
    public String getOrganizationId(){
        return organizationId;
    }

    public void setOrganizationId(String organizationId){
        this.organizationId = organizationId;
    }
    public String getManageOrgIds(){
        return manageOrgIds;
    }

    public void setManageOrgIds(String manageOrgIds){
        this.manageOrgIds = manageOrgIds;
    }
    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getSalt(){
        return salt;
    }

    public void setSalt(String salt){
        this.salt = salt;
    }
    public String getRoleIds(){
        return roleIds;
    }

    public void setRoleIds(String roleIds){
        this.roleIds = roleIds;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhoto(){
        return photo;
    }

    public void setPhoto(String photo){
        this.photo = photo;
    }
    public String getStationNm(){
        return stationNm;
    }

    public void setStationNm(String stationNm){
        this.stationNm = stationNm;
    }
    public String getLoginIp(){
        return loginIp;
    }

    public void setLoginIp(String loginIp){
        this.loginIp = loginIp;
    }
    public String getLoginDate(){
        return loginDate;
    }

    public void setLoginDate(String loginDate){
        this.loginDate = loginDate;
    }
    public String getIsOff(){
        return isOff;
    }

    public void setIsOff(String isOff){
        this.isOff = isOff;
    }
    public String getLocked(){
        return locked;
    }

    public void setLocked(String locked){
        this.locked = locked;
    }
    public String getIsDept(){
        return isDept;
    }

    public void setIsDept(String isDept){
        this.isDept = isDept;
    }
    public String getPhoneDeviceId(){
        return phoneDeviceId;
    }

    public void setPhoneDeviceId(String phoneDeviceId){
        this.phoneDeviceId = phoneDeviceId;
    }
    public String getBalance(){
        return balance;
    }

    public void setBalance(String balance){
        this.balance = balance;
    }
    public String getUserTypeCd(){
        return userTypeCd;
    }

    public void setUserTypeCd(String userTypeCd){
        this.userTypeCd = userTypeCd;
    }
    public String getSexCd(){
        return sexCd;
    }

    public void setSexCd(String sexCd){
        this.sexCd = sexCd;
    }
    public String getRemarks(){
        return remarks;
    }

    public void setRemarks(String remarks){
        this.remarks = remarks;
    }
    public String getCreateBy(){
        return createBy;
    }

    public void setCreateBy(String createBy){
        this.createBy = createBy;
    }
    public String getCreateDate(){
        return createDate;
    }

    public void setCreateDate(String createDate){
        this.createDate = createDate;
    }
    public String getUpdateBy(){
        return updateBy;
    }

    public void setUpdateBy(String updateBy){
        this.updateBy = updateBy;
    }
    public String getUpdateDate(){
        return updateDate;
    }

    public void setUpdateDate(String updateDate){
        this.updateDate = updateDate;
    }
    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "PersonUserEntity{" +
            "id='" + id + '\'' + ", " + 
            "no='" + no + '\'' + ", " + 
            "organizationId='" + organizationId + '\'' + ", " + 
            "manageOrgIds='" + manageOrgIds + '\'' + ", " + 
            "username='" + username + '\'' + ", " + 
            "password='" + password + '\'' + ", " + 
            "salt='" + salt + '\'' + ", " + 
            "roleIds='" + roleIds + '\'' + ", " + 
            "name='" + name + '\'' + ", " + 
            "email='" + email + '\'' + ", " + 
            "phone='" + phone + '\'' + ", " + 
            "photo='" + photo + '\'' + ", " + 
            "stationNm='" + stationNm + '\'' + ", " + 
            "loginIp='" + loginIp + '\'' + ", " + 
            "loginDate='" + loginDate + '\'' + ", " + 
            "isOff='" + isOff + '\'' + ", " + 
            "locked='" + locked + '\'' + ", " + 
            "isDept='" + isDept + '\'' + ", " + 
            "phoneDeviceId='" + phoneDeviceId + '\'' + ", " + 
            "balance='" + balance + '\'' + ", " + 
            "userTypeCd='" + userTypeCd + '\'' + ", " + 
            "sexCd='" + sexCd + '\'' + ", " + 
            "remarks='" + remarks + '\'' + ", " + 
            "createBy='" + createBy + '\'' + ", " + 
            "createDate='" + createDate + '\'' + ", " + 
            "updateBy='" + updateBy + '\'' + ", " + 
            "updateDate='" + updateDate + '\'' + ", " + 
            "status='" + status + '\'' +
        '}';
    }
}
