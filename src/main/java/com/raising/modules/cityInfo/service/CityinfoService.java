package com.raising.modules.cityInfo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.cityInfo.dao.CityinfoDao;
import com.raising.modules.cityInfo.entity.CityinfoEntity;

/**
*  Service层
* @author chy
* @createTime 2019-02-28 14:42:17
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class CityinfoService extends CrudService<CityinfoDao, CityinfoEntity> {

}
