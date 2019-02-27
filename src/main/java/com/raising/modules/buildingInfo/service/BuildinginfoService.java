package com.raising.modules.buildingInfo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.buildingInfo.dao.BuildinginfoDao;
import com.raising.modules.buildingInfo.entity.BuildinginfoEntity;

/**
*  Service层
* @author fsd
* @createTime 2019-02-26 15:27:23
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class BuildinginfoService extends CrudService<BuildinginfoDao, BuildinginfoEntity> {

}
