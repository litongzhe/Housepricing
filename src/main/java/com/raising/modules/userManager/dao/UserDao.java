package com.raising.modules.userManager.dao;

import com.raising.framework.dao.ICrudDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.raising.modules.userManager.entity.UserEntity;

/**
*  DAO接口
* @author fsd
* @createTime 2019-02-27 11:09:34
*/
@Mapper
@Repository
public interface UserDao extends ICrudDao<UserEntity> {

}
