package com.raising.modules.buildingPrice.service;

import com.raising.framework.entity.ResultCode;
import com.raising.framework.entity.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.buildingPrice.dao.InfodataDao;
import com.raising.modules.buildingPrice.entity.InfodataEntity;

import java.util.HashMap;

/**
*  Service层
* @author fsd
* @createTime 2019-03-04 14:17:51
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class InfodataService extends CrudService<InfodataDao, InfodataEntity> {

    /**
     * 获取 在价格面积区间内获取 Page信息
     * @author fsd
     * @param infodataEntity
     * @param hashMap
     * @return
     */
    ResultVo getPageByPriceArea(InfodataEntity infodataEntity, HashMap<String,String> hashMap){
        return new ResultVo(ResultCode.OK,this.dao.getPageByPriceArea(infodataEntity,hashMap));
    }

}
