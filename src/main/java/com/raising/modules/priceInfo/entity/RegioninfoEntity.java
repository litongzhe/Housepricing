package com.raising.modules.priceInfo.entity;

import com.raising.framework.entity.BaseEntity;

/**
* 
* @author fsd
* @createTime 2019-03-04 11:18:27
*/
public class RegioninfoEntity extends BaseEntity<RegioninfoEntity>{

    /**  */
    private String id;
    /**  */
    private String cityname;
    /**  */
    private String regionname;
    /**  */
    private String avgprice;
    /**  */
    private String lat;
    /**  */
    private String lng;

    public RegioninfoEntity() {}

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getCityname(){
        return cityname;
    }

    public void setCityname(String cityname){
        this.cityname = cityname;
    }
    public String getRegionname(){
        return regionname;
    }

    public void setRegionname(String regionname){
        this.regionname = regionname;
    }
    public String getAvgprice(){
        return avgprice;
    }

    public void setAvgprice(String avgprice){
        this.avgprice = avgprice;
    }
    public String getLat(){
        return lat;
    }

    public void setLat(String lat){
        this.lat = lat;
    }
    public String getLng(){
        return lng;
    }

    public void setLng(String lng){
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "RegioninfoEntity{" +
            "id='" + id + '\'' + ", " + 
            "cityname='" + cityname + '\'' + ", " + 
            "regionname='" + regionname + '\'' + ", " + 
            "avgprice='" + avgprice + '\'' + ", " + 
            "lat='" + lat + '\'' + ", " + 
            "lng='" + lng + '\'' +
        '}';
    }
}
