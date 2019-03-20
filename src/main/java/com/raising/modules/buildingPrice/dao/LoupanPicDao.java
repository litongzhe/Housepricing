package com.raising.modules.buildingPrice.dao;

import com.raising.framework.dao.ICrudDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.raising.modules.buildingPrice.entity.LoupanPicEntity;

import java.util.List;

/**
*  DAO接口
* @author fsd
* @createTime 2019-03-20 14:38:23
*/
@Mapper
@Repository
public interface LoupanPicDao extends ICrudDao<LoupanPicEntity> {

    List<LoupanPicEntity> getListPicByUrl(LoupanPicEntity loupanPicEntity);

    LoupanPicEntity getOnePicByUrl(LoupanPicEntity loupanPicEntity);
}
