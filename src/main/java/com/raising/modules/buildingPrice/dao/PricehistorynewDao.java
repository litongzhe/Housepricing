package com.raising.modules.buildingPrice.dao;

import com.raising.framework.dao.ICrudDao;
import com.raising.modules.buildingPrice.entity.provinceEntity;
import com.raising.modules.buildingPrice.entity.cityEntity;
import com.raising.modules.buildingPrice.entity.regionEntity;
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
    public List<provinceEntity> getProvince();
    public List<cityEntity> getCity(cityEntity c);
    public List<regionEntity> getRegion(regionEntity r);
    List<PricehistorynewEntity> getHistoryByProvince(PricehistorynewEntity var1);
    List<PricehistorynewEntity> getHistoryByCity(PricehistorynewEntity var1);
}
