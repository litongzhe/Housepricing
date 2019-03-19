package com.raising.modules.buildingPrice.dao;

import com.raising.framework.dao.ICrudDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.raising.modules.buildingPrice.entity.BuildColBrowEntity;

/**
*  DAO接口
* @author fsd
* @createTime 2019-03-18 16:09:58
*/
@Mapper
@Repository
public interface BuildColBrowDao extends ICrudDao<BuildColBrowEntity> {

}
