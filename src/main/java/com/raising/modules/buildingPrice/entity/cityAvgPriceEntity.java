package com.raising.modules.buildingPrice.entity;

public class cityAvgPriceEntity {
    /**  */
    private String cityName;
    /**  */
    private Double avgPrice;

    public void setCityName(String cityName){
        this.cityName = cityName;
    }
    public String getCityName(){
        return cityName;
    }

    public void setAvgPrice(Double avgPrice){
        this.avgPrice = avgPrice;
    }
    public Double getAvgPrice(){
        return avgPrice;
    }


}
