package com.raising.modules.buildingPrice.dao;

import com.raising.framework.dao.ICrudDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.raising.modules.buildingPrice.entity.RegioninfoEntity;

/**
*  DAO接口
* @author fsd
* @createTime 2019-03-04 14:17:51
*/
@Mapper
@Repository
public interface RegioninfoDao extends ICrudDao<RegioninfoEntity> {

}
