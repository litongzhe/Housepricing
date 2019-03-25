package com.raising.modules.buildingPrice.entity;

import com.raising.framework.entity.BaseEntity;

/**
* 
* @author litongzhe
* @createTime 2019-03-15 16:02:46
*/
public class CountrypcrEntity extends BaseEntity<CountrypcrEntity>{

    /**  */
    private String province;
    /**  */
    private String city;
    /**  */
    private String region;
    /**  */
    private String id;

    public CountrypcrEntity() {}

    public String getProvince(){
        return province;
    }

    public void setProvince(String province){
        this.province = province;
    }
    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }
    public String getRegion(){
        return region;
    }

    public void setRegion(String region){
        this.region = region;
    }
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "CountrypcrEntity{" +
            "province='" + province + '\'' + ", " + 
            "city='" + city + '\'' + ", " + 
            "region='" + region + '\'' + ", " + 
            "id='" + id + '\'' +
        '}';
    }
}
