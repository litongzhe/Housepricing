package com.raising.modules.buildingInfo.dao;

import com.raising.framework.dao.ICrudDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.raising.modules.buildingInfo.entity.BuildinginfoEntity;

/**
*  DAO接口
* @author fsd
* @createTime 2019-02-26 15:27:23
*/
@Mapper
@Repository
public interface BuildinginfoDao extends ICrudDao<BuildinginfoEntity> {

}
