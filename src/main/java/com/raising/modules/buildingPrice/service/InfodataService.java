package com.raising.modules.buildingPrice.service;

import com.raising.framework.entity.ResultCode;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;
import com.raising.modules.buildingPrice.entity.LoupanPicEntity;
import com.raising.modules.buildingPrice.entity.QueryInfoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.buildingPrice.dao.InfodataDao;
import com.raising.modules.buildingPrice.entity.InfodataEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Service层
 *
 * @author fsd
 * @createTime 2019-03-04 14:17:51
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class InfodataService extends CrudService<InfodataDao, InfodataEntity> {

    /**
     * 获取 在价格面积区间内获取 Page信息
     *
     * @param
     * @param
     * @return
     * @author fsd
     */

    @Autowired
    LoupanPicService loupanPicService;

    public ResultVo getPageByPriceArea(Page<QueryInfoData> page) {
        List<QueryInfoData> list = this.dao.getPageByPriceArea(page);
        List<String> urls = new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            urls.add(list.get(i).getUrl());
        }
        ResultVo result = loupanPicService.getOnePicByUrl(urls);
        if (result.getCode() != ResultVo.SUCCESS)
            return result;
        List<LoupanPicEntity> picList = (List<LoupanPicEntity>) result.getData();
        int i = 0;
        for (QueryInfoData item : list) {
            item.setUrl(picList.get(i++).getPic());
        }
         page.setResults(list);
        return new ResultVo(ResultCode.OK, page);
    }

}
