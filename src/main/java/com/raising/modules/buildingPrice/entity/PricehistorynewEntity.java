package com.raising.modules.buildingPrice.entity;

import com.raising.framework.entity.BaseEntity;

/**
* 
* @author fsd
* @createTime 2019-03-05 11:09:22
*/
public class PricehistorynewEntity extends BaseEntity<PricehistorynewEntity>{

    /**  */
    private String year;
    /**  */
    private String mouth;
    /**  */
    private String province;
    /**  */
    private String city;
    /**  */
    private String citylevel;
    /**  */
    private String longitude;
    /**  */
    private String twist;
    /**  */
    private String houseprice;
    /**  */
    private String proportion;
    /**  */
    private String inc;
    /**  */
    private String inc2;
    /**  */
    private String pricehistoryid;

    public PricehistorynewEntity() {}

    public String getYear(){
        return year;
    }

    public void setYear(String year){
        this.year = year;
    }
    public String getMouth(){
        return mouth;
    }

    public void setMouth(String mouth){
        this.mouth = mouth;
    }
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
    public String getCitylevel(){
        return citylevel;
    }

    public void setCitylevel(String citylevel){
        this.citylevel = citylevel;
    }
    public String getLongitude(){
        return longitude;
    }

    public void setLongitude(String longitude){
        this.longitude = longitude;
    }
    public String getTwist(){
        return twist;
    }

    public void setTwist(String twist){
        this.twist = twist;
    }
    public String getHouseprice(){
        return houseprice;
    }

    public void setHouseprice(String houseprice){
        this.houseprice = houseprice;
    }
    public String getProportion(){
        return proportion;
    }

    public void setProportion(String proportion){
        this.proportion = proportion;
    }
    public String getInc(){
        return inc;
    }

    public void setInc(String inc){
        this.inc = inc;
    }
    public String getInc2(){
        return inc2;
    }

    public void setInc2(String inc2){
        this.inc2 = inc2;
    }
    public String getPricehistoryid(){
        return pricehistoryid;
    }

    public void setPricehistoryid(String pricehistoryid){
        this.pricehistoryid = pricehistoryid;
    }

    @Override
    public String toString() {
        return "PricehistorynewEntity{" +
            "year='" + year + '\'' + ", " + 
            "mouth='" + mouth + '\'' + ", " + 
            "province='" + province + '\'' + ", " + 
            "city='" + city + '\'' + ", " + 
            "citylevel='" + citylevel + '\'' + ", " + 
            "longitude='" + longitude + '\'' + ", " + 
            "twist='" + twist + '\'' + ", " + 
            "houseprice='" + houseprice + '\'' + ", " + 
            "proportion='" + proportion + '\'' + ", " + 
            "inc='" + inc + '\'' + ", " + 
            "inc2='" + inc2 + '\'' + ", " + 
            "pricehistoryid='" + pricehistoryid + '\'' +
        '}';
    }
}
