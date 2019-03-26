package com.raising.modules.buildingPrice.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QueryInfoData extends InfodataEntity implements Serializable {
    int startPrice;
    int endPrice;
    int startArea;
    List<String> projectFeaturesList = new ArrayList<>();
    List<String> propertyTypeList = new ArrayList<>();

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    String picUrl;

    public List<String> getPropertyTypeList() {
        return propertyTypeList;
    }

    public List<String> getProjectFeaturesList() {
        return projectFeaturesList;
    }

    public void setPropertyTypeList(List<String> propertyTypeList) {
        this.propertyTypeList = propertyTypeList;
    }

    public void setProjectFeaturesList(List<String> projectFeaturesList) {
        this.projectFeaturesList = projectFeaturesList;
    }




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
