package com.raising.modules.PersonUser.entity;

import com.raising.framework.entity.BaseEntity;

/**
* 
* @author fsd
* @createTime 2019-03-16 16:06:16
*/
public class UserBuildingEntity extends BaseEntity<UserBuildingEntity>{

    /**  */
    private String id;
    /**  */
    private String userid;
    /**  */
    private String buildingid;

    public UserBuildingEntity() {}

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getUserid(){
        return userid;
    }

    public void setUserid(String userid){
        this.userid = userid;
    }
    public String getBuildingid(){
        return buildingid;
    }

    public void setBuildingid(String buildingid){
        this.buildingid = buildingid;
    }

    @Override
    public String toString() {
        return "UserBuildingEntity{" +
            "id='" + id + '\'' + ", " + 
            "userid='" + userid + '\'' + ", " + 
            "buildingid='" + buildingid + '\'' +
        '}';
    }
}
