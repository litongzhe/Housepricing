package com.raising.modules.buildingPrice.dao;

import com.raising.framework.dao.ICrudDao;
import com.raising.modules.buildingPrice.entity.cityAvgPriceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.raising.modules.buildingPrice.entity.RegioninfoEntity;

import java.security.PublicKey;
import java.util.List;

/**
*  DAO接口
* @author fsd
* @createTime 2019-03-04 14:17:51
*/
@Mapper
@Repository
public interface RegioninfoDao extends ICrudDao<RegioninfoEntity> {

    public List<cityAvgPriceEntity> getCityAvgPrice();

}
