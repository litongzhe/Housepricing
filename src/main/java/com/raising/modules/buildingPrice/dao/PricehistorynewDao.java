package com.raising.modules.buildingPrice.dao;

import com.raising.framework.dao.ICrudDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.raising.modules.buildingPrice.entity.PricehistorynewEntity;

import java.util.List;

/**
*  DAO接口
* @author fsd
* @createTime 2019-03-05 11:09:22
*/
@Mapper
@Repository
public interface PricehistorynewDao extends ICrudDao<PricehistorynewEntity> {
    List<PricehistorynewEntity> getHistoryByProvince(PricehistorynewEntity var1);
    List<PricehistorynewEntity> getHistoryByCity(PricehistorynewEntity var1);
}
