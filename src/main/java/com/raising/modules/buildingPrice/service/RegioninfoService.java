package com.raising.modules.buildingPrice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.buildingPrice.dao.RegioninfoDao;
import com.raising.modules.buildingPrice.entity.RegioninfoEntity;

import java.util.List;

/**
*  Service层
* @author fsd
* @createTime 2019-03-04 14:17:51
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class RegioninfoService extends CrudService<RegioninfoDao, RegioninfoEntity> {


}
