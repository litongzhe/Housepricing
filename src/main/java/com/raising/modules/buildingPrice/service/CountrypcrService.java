package com.raising.modules.buildingPrice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.buildingPrice.dao.CountrypcrDao;
import com.raising.modules.buildingPrice.entity.CountrypcrEntity;

/**
*  Service层
* @author litongzhe
* @createTime 2019-03-15 16:02:46
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class CountrypcrService extends CrudService<CountrypcrDao, CountrypcrEntity> {

}
