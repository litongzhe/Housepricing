package com.raising.modules.buildingPrice.dao;

import com.raising.framework.dao.ICrudDao;
import com.raising.framework.mybaits.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.raising.modules.buildingPrice.entity.InfodataEntity;

import java.util.HashMap;

/**
*  DAO接口
* @author fsd
* @createTime 2019-03-04 14:17:51
*/
@Mapper
@Repository
public interface InfodataDao extends ICrudDao<InfodataEntity> {
    Page<InfodataEntity> getPageByPriceArea(InfodataEntity infodataEntity, HashMap<String,String> hashMap);
}
