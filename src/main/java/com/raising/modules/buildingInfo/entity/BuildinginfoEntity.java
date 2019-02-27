package com.raising.modules.buildingInfo.entity;

import com.raising.framework.entity.BaseEntity;

/**
* 
* @author fsd
* @createTime 2019-02-26 15:27:23
*/
public class BuildinginfoEntity extends BaseEntity<BuildinginfoEntity>{

    /**  */
    private String id;
    /**  */
    private String loupanname;
    /**  */
    private String price;
    /**  */
    private String location;

    public BuildinginfoEntity() {}

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getLoupanname(){
        return loupanname;
    }

    public void setLoupanname(String loupanname){
        this.loupanname = loupanname;
    }
    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }
    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    @Override
    public String toString() {
        return "BuildinginfoEntity{" +
            "id='" + id + '\'' + ", " + 
            "loupanname='" + loupanname + '\'' + ", " + 
            "price='" + price + '\'' + ", " + 
            "location='" + location + '\'' +
        '}';
    }
}
