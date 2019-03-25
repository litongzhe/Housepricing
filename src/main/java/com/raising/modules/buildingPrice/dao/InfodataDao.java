package com.raising.modules.buildingPrice.dao;

import com.raising.framework.dao.ICrudDao;
import com.raising.framework.mybaits.Page;
import com.raising.modules.buildingPrice.entity.QueryInfoData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.raising.modules.buildingPrice.entity.InfodataEntity;

import java.util.HashMap;
import java.util.List;

/**
*  DAO接口
* @author fsd
* @createTime 2019-03-04 14:17:51
*/
@Mapper
@Repository
public interface InfodataDao extends ICrudDao<InfodataEntity> {

    List<QueryInfoData> getPageByPriceArea(Page<QueryInfoData> page);

    /**
     * 获取queryInfoData 要求的所有数据。返回结果给 相似楼盘函数
     * @author fsd
     * @param queryInfoData
     * @return
     */
    List<QueryInfoData> getSimilarList(QueryInfoData queryInfoData);


}
