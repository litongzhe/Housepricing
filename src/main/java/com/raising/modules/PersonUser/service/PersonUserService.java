package com.raising.modules.PersonUser.service;

import com.raising.framework.entity.ResultCode;
import com.raising.framework.entity.ResultVo;
import com.raising.modules.sys.dao.UserDao;
import com.raising.utils.PasswordEntity;
import com.raising.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.PersonUser.dao.PersonUserDao;
import com.raising.modules.PersonUser.entity.PersonUserEntity;

import javax.persistence.criteria.CriteriaBuilder;

/**
* 用户表 Service层
* @author fsd
* @createTime 2019-02-28 16:06:42
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class PersonUserService extends CrudService<PersonUserDao, PersonUserEntity> {
    @Autowired
    PersonUserDao personUserDao;
    @Autowired
    private PasswordUtils passwordUtils;
    /**
     * 按邮箱地址查询是否有用户
     * @param email
     * @return
     */
    public PersonUserEntity findByUserEmail(String email){
        PersonUserEntity puEntity = new PersonUserEntity();
        puEntity.setEmail(email);
        return personUserDao.getByParam(puEntity);
    }



    public PersonUserEntity findByUserName(String Name){
        PersonUserEntity puEntity = new PersonUserEntity();
        puEntity.setUsername(Name);
        return personUserDao.getByParam(puEntity);
    }

    /**
     * 按照用户ID搜索用户
     * @param Id
     * @return
     */
    public PersonUserEntity findByUserId(String Id){
        PersonUserEntity puEntity = new PersonUserEntity();
        puEntity.setId(Id);
        return personUserDao.getByParam(puEntity);
    }

    /**
     * 插入新的用户
     * @param entity
     * @return
     */
    public ResultVo addUser(PersonUserEntity entity){
        PasswordEntity passwordEntity = this.passwordUtils.encryptPassword(entity.getPassword());
        entity.setPassword(passwordEntity.getPassword());
        entity.setSalt(passwordEntity.getSalt());
        personUserDao.insert(entity);
        return new ResultVo(ResultCode.OK, entity.getId());
    }




}
