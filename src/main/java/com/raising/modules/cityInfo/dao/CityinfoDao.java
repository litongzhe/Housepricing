package com.raising.modules.cityInfo.dao;

import com.raising.framework.dao.ICrudDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.raising.modules.cityInfo.entity.CityinfoEntity;

/**
*  DAO接口
* @author chy
* @createTime 2019-02-28 14:42:17
*/
@Mapper
@Repository
public interface CityinfoDao extends ICrudDao<CityinfoEntity> {

}
