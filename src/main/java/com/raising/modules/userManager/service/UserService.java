package com.raising.modules.userManager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.userManager.dao.UserDao;
import com.raising.modules.userManager.entity.UserEntity;

/**
*  Service层
* @author fsd
* @createTime 2019-02-27 11:09:34
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService extends CrudService<UserDao, UserEntity> {

}
