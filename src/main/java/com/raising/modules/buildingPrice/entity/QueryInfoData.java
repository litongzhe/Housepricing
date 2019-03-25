package com.raising.modules.buildingPrice.entity;

import java.io.Serializable;

public class QueryInfoData extends InfodataEntity implements Serializable {
    int startPrice;
    int endPrice;
    int startArea;

    public QueryInfoData() {
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public int getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(int endPrice) {
        this.endPrice = endPrice;
    }

    public int getStartArea() {
        return startArea;
    }

    public void setStartArea(int startArea) {
        this.startArea = startArea;
    }

    public int getEndArea() {
        return endArea;
    }

    public void setEndArea(int endArea) {
        this.endArea = endArea;
    }

    int endArea;
}
