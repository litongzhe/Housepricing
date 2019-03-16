package com.raising.modules.PersonUser.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.PersonUser.dao.UserBuildingDao;
import com.raising.modules.PersonUser.entity.UserBuildingEntity;

/**
*  Service层
* @author fsd
* @createTime 2019-03-16 16:06:16
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserBuildingService extends CrudService<UserBuildingDao, UserBuildingEntity> {

}
