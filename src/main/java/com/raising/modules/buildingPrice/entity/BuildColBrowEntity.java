package com.raising.modules.buildingPrice.entity;

import com.raising.framework.entity.BaseEntity;

/**
* 
* @author fsd
* @createTime 2019-03-18 16:09:58
*/
public class BuildColBrowEntity extends BaseEntity<BuildColBrowEntity>{

    /** 小区的id号对应infodata的id */
    private String xiaoquid;
    /** 该小区信息收藏数目 */
    private String collectnum;
    /** 该小区被浏览次数 */
    private String browsenum;

    public BuildColBrowEntity() {}

    public String getXiaoquid(){
        return xiaoquid;
    }

    public void setXiaoquid(String xiaoquid){
        this.xiaoquid = xiaoquid;
    }
    public String getCollectnum(){
        return collectnum;
    }

    public void setCollectnum(String collectnum){
        this.collectnum = collectnum;
    }
    public String getBrowsenum(){
        return browsenum;
    }

    public void setBrowsenum(String browsenum){
        this.browsenum = browsenum;
    }

    @Override
    public String toString() {
        return "BuildColBrowEntity{" +
            "xiaoquid='" + xiaoquid + '\'' + ", " + 
            "collectnum='" + collectnum + '\'' + ", " + 
            "browsenum='" + browsenum + '\'' +
        '}';
    }
}
