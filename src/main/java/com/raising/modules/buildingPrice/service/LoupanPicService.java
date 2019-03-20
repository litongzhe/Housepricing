package com.raising.modules.buildingPrice.service;

import com.raising.framework.entity.ResultCode;
import com.raising.framework.entity.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.buildingPrice.dao.LoupanPicDao;
import com.raising.modules.buildingPrice.entity.LoupanPicEntity;

import java.util.ArrayList;
import java.util.List;

/**
*  Service层
* @author fsd
* @createTime 2019-03-20 14:38:23
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class LoupanPicService extends CrudService<LoupanPicDao, LoupanPicEntity> {

    /**
     * 为一批loupanurl 分别返回 一张图片
     * @author fsd
     * @param loupanurl
     * @return
     */
    public ResultVo getOnePicByUrl(List<String> loupanurl){
        List<LoupanPicEntity> results = new ArrayList<>();
        LoupanPicEntity loupanPicEntity = new LoupanPicEntity();

        if(loupanurl == null || loupanurl.size() == 0){
            return new ResultVo(ResultCode.EMPTY_ROW, "when find a pic for every url in List<loupanurl>, the list is null or size==0");
        }
        for(String s : loupanurl){
            if(s == null || s.equals("")){
                results.add(new LoupanPicEntity());
            }
            loupanPicEntity.setUrl(s);
            LoupanPicEntity e = this.dao.getOnePicByUrl(loupanPicEntity);
            //若无这个url对应的图片 则加一个空的 LoupanPicEntity
            if(e == null){
                results.add(new LoupanPicEntity());
            }else{
                results.add(e);
            }
        }
        return new ResultVo(ResultCode.OK, results);
    }

    /**
     * 根据 url 获取 一个 楼盘的多个图片
     * @author fsd
     * @param loupanurl
     * @return
     */
    public ResultVo getListPicByUrl(String loupanurl){
        if(loupanurl == null || loupanurl.equals("")){
            return new ResultVo(ResultCode.EMPTY_ROW,"when find pics by a loupanUrl, url is null or ''");
        }
        LoupanPicEntity loupanPicEntity = new LoupanPicEntity();
        loupanPicEntity.setUrl(loupanurl);
        List<LoupanPicEntity> entitys = this.dao.getListPicByUrl(loupanPicEntity);
        if(entitys == null || entitys.size() ==0 ){
            return new ResultVo(ResultCode.EMPTY_ROW,"when find pics by a loupanUrl, there is no picinfo in dataset");
        }
        return new ResultVo(ResultCode.OK, entitys);

    }


}
