package com.raising.modules.PersonUser.dao;

import com.raising.framework.dao.ICrudDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.raising.modules.PersonUser.entity.PersonUserEntity;

/**
* 用户表 DAO接口
* @author fsd
* @createTime 2019-02-28 16:06:42
*/
@Mapper
@Repository
public interface PersonUserDao extends ICrudDao<PersonUserEntity> {

}
