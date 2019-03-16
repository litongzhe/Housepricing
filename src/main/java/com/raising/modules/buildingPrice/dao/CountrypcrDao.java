package com.raising.modules.buildingPrice.dao;

import com.raising.framework.dao.ICrudDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.raising.modules.buildingPrice.entity.CountrypcrEntity;

/**
*  DAO接口
* @author litongzhe
* @createTime 2019-03-15 16:02:46
*/
@Mapper
@Repository
public interface CountrypcrDao extends ICrudDao<CountrypcrEntity> {

}
