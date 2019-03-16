package com.raising.modules.buildingPrice.service;

import com.raising.framework.entity.ResultCode;
import com.raising.framework.entity.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.buildingPrice.dao.PricehistorynewDao;
import com.raising.modules.buildingPrice.entity.PricehistorynewEntity;

/**
*  Service层
* @author fsd
* @createTime 2019-03-05 11:09:22
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class PricehistorynewService extends CrudService<PricehistorynewDao, PricehistorynewEntity> {
    @Autowired
    PricehistorynewDao pricehistorynewDao;
    public ResultVo getHistoryByProvince(PricehistorynewEntity entity) {
        return new ResultVo(ResultCode.OK, pricehistorynewDao.getHistoryByProvince(entity));
    }

    public ResultVo getHistoryByCity(PricehistorynewEntity entity) {
        return new ResultVo(ResultCode.OK, pricehistorynewDao.getHistoryByCity(entity));
    }


}
