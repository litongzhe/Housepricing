package com.raising.modules.priceInfo.dao;

import com.raising.framework.dao.ICrudDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.raising.modules.priceInfo.entity.RegioninfoEntity;

/**
*  DAO接口
* @author fsd
* @createTime 2019-03-04 11:18:27
*/
@Mapper
@Repository
public interface RegioninfoDao extends ICrudDao<RegioninfoEntity> {

}
