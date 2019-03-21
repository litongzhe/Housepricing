package com.raising.modules.buildingPrice.entity;

import java.io.Serializable;

public class QueryInfoData extends InfodataEntity implements Serializable {
    String startPrice;
    String endPrice;

    @Override
    public String toString() {
        return "QueryInfoData{" +
                "startPrice='" + startPrice + '\'' +
                ", endPrice='" + endPrice + '\'' +
                ", startArea='" + startArea + '\'' +
                ", endArea='" + endArea + '\'' +
                '}';
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(String endPrice) {
        this.endPrice = endPrice;
    }

    public String getStartArea() {
        return startArea;
    }

    public void setStartArea(String startArea) {
        this.startArea = startArea;
    }

    public String getEndArea() {
        return endArea;
    }

    public void setEndArea(String endArea) {
        this.endArea = endArea;
    }

    public QueryInfoData() {
    }

    public QueryInfoData(String startPrice, String endPrice, String startArea, String endArea) {
        this.startPrice = startPrice;
        this.endPrice = endPrice;
        this.startArea = startArea;
        this.endArea = endArea;
    }

    String startArea;
    String endArea;
}
