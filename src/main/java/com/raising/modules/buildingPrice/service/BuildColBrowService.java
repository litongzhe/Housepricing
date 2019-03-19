package com.raising.modules.buildingPrice.service;

import com.raising.framework.entity.ResultCode;
import com.raising.framework.entity.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raising.framework.service.CrudService;
import com.raising.modules.buildingPrice.dao.BuildColBrowDao;
import com.raising.modules.buildingPrice.entity.BuildColBrowEntity;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.List;

/**
*  Service层
* @author fsd
* @createTime 2019-03-18 16:09:58
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class BuildColBrowService extends CrudService<BuildColBrowDao, BuildColBrowEntity> {

    @Autowired
    BuildColBrowDao buildColBrowDao;

    /**
     * get data by id
     * @author fsd
     * @param buildColBrowEntity
     * @return
     */
    public ResultVo getByID(BuildColBrowEntity buildColBrowEntity){

        BuildColBrowEntity entity = new BuildColBrowEntity();
        if(buildColBrowEntity.getXiaoquid() == null || buildColBrowEntity.getXiaoquid().equals("")){
            return new ResultVo(ResultCode.EMPTY_ROW,"when getID, id is null or ''");
        }
        entity.setXiaoquid(buildColBrowEntity.getXiaoquid());
        BuildColBrowEntity liste = buildColBrowDao.getByParam(entity);

        return new ResultVo(ResultCode.OK, liste);

    }

    /**
     * 增加1 收藏数目
     *  @author fsd
     * @param buildColBrowEntity
     * @return
     */
    public ResultVo increaseCollection(BuildColBrowEntity buildColBrowEntity){
        // id is not right
        ResultVo resultVo = this.getByID(buildColBrowEntity);
        if(resultVo.getCode() != ResultCode.OK.getCode()){
            return resultVo;
        }
        // without this info in dataset,so insert this data
        if(resultVo.getData() == null ){
            buildColBrowEntity.setCollectnum("1");
            buildColBrowEntity.setBrowsenum("1");
            return new ResultVo(ResultCode.OK, buildColBrowDao.insert(buildColBrowEntity));
        }
        // this data exist in dataset, so update the num
        buildColBrowEntity = (BuildColBrowEntity) resultVo.getData();
        Integer collectNum = Integer.valueOf(buildColBrowEntity.getCollectnum());
        buildColBrowEntity.setCollectnum(String.valueOf(collectNum+1));
        return new ResultVo(ResultCode.OK,buildColBrowDao.update(buildColBrowEntity));
    }

    /**
     * 减少1 收藏数目
     * @author fsd
     * @param buildColBrowEntity
     * @return
     */
    public ResultVo decreaseCollection(BuildColBrowEntity buildColBrowEntity){
        // id is not right
        ResultVo resultVo = this.getByID(buildColBrowEntity);
        if(resultVo.getCode() != ResultCode.OK.getCode()){
            return resultVo;
        }
        // no this info in dataset,so insert this data
        if(resultVo.getData() == null ){
            return new ResultVo(ResultCode.EMPTY_ROW, "when decrease collection num, there is no data with id ="+buildColBrowEntity.getXiaoquid());
        }
        // this data exist in dataset, so update the num
        buildColBrowEntity = (BuildColBrowEntity) resultVo.getData();
        Integer collectNum = Integer.valueOf(buildColBrowEntity.getCollectnum());
        buildColBrowEntity.setCollectnum(String.valueOf(collectNum-1));
        return new ResultVo(ResultCode.OK,buildColBrowDao.update(buildColBrowEntity));
    }

    /**
     * 增加1 浏览数目
     * @author fsd
     * @param buildColBrowEntity
     * @return
     */
    public ResultVo increaseBrowse(BuildColBrowEntity buildColBrowEntity){
        // id is not right
        ResultVo resultVo = this.getByID(buildColBrowEntity);
        if(resultVo.getCode() != ResultCode.OK.getCode()){
            return resultVo;
        }
        // no this info in dataset,so insert this data
        if(resultVo.getData() == null){
            buildColBrowEntity.setBrowsenum("1");
            return new ResultVo(ResultCode.OK, buildColBrowDao.insert(buildColBrowEntity));
        }
        buildColBrowEntity = (BuildColBrowEntity) resultVo.getData();
        Integer browseNum = Integer.valueOf(buildColBrowEntity.getBrowsenum());
        buildColBrowEntity.setCollectnum(String.valueOf(browseNum+1));
        return new ResultVo(ResultCode.OK,buildColBrowDao.update(buildColBrowEntity));
    }

    /**
     * 减少1 浏览数目
     * @author fsd
     * @param buildColBrowEntity
     * @return
     */
    public ResultVo decreaseBrowse(BuildColBrowEntity buildColBrowEntity){
        // id is not right
        ResultVo resultVo = this.getByID(buildColBrowEntity);
        if(resultVo.getCode() != ResultCode.OK.getCode()){
            return resultVo;
        }
        // no this info in dataset,so insert this data
        if(resultVo.getData() == null ){
            return new ResultVo(ResultCode.EMPTY_ROW, "when decrease browse num, there is no data with id ="+buildColBrowEntity.getXiaoquid());
        }
        // this data exist in dataset, so update the num
        buildColBrowEntity = (BuildColBrowEntity) resultVo.getData();
        Integer browseNum = Integer.valueOf(buildColBrowEntity.getBrowsenum());
        buildColBrowEntity.setCollectnum(String.valueOf(browseNum-1));
        return new ResultVo(ResultCode.OK,buildColBrowDao.update(buildColBrowEntity));
    }


}
