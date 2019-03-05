package com.raising.modules.buildingPrice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.buildingPrice.dao.PricehistorynewDao;
import com.raising.modules.buildingPrice.entity.PricehistorynewEntity;

/**
*  Service层
* @author fsd
* @createTime 2019-03-05 11:09:22
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class PricehistorynewService extends CrudService<PricehistorynewDao, PricehistorynewEntity> {

}
