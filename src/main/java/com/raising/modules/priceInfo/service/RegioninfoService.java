package com.raising.modules.priceInfo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.priceInfo.dao.RegioninfoDao;
import com.raising.modules.priceInfo.entity.RegioninfoEntity;

/**
*  Service层
* @author fsd
* @createTime 2019-03-04 11:18:27
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class RegioninfoService extends CrudService<RegioninfoDao, RegioninfoEntity> {

}
