package com.raising.modules.PersonUser.dao;

import com.raising.framework.dao.ICrudDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.raising.modules.PersonUser.entity.UserBuildingEntity;

/**
*  DAO接口
* @author fsd
* @createTime 2019-03-16 16:06:16
*/
@Mapper
@Repository
public interface UserBuildingDao extends ICrudDao<UserBuildingEntity> {

}
