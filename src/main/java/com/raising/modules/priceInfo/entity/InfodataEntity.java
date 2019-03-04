package com.raising.modules.priceInfo.entity;

import com.raising.framework.entity.BaseEntity;

/**
* 
* @author fsd
* @createTime 2019-03-04 11:18:27
*/
public class InfodataEntity extends BaseEntity<InfodataEntity>{

    /**  */
    private String date;
    /**  */
    private String city;
    /**  */
    private String region;
    /**  */
    private String xiaoqu;
    /**  */
    private String price;
    /**  */
    private String total;
    /**  */
    private String url;
    /**  */
    private String propertytype;
    /**  */
    private String referenceprice;
    /**  */
    private String projectfeatures;
    /**  */
    private String regionallocation;
    /**  */
    private String propertyaddress;
    /**  */
    private String salesofficeaddress;
    /**  */
    private String developer;
    /**  */
    private String buildingtype;
    /**  */
    private String landscapingratio;
    /**  */
    private String sitearea;
    /**  */
    private String floorarearatio;
    /**  */
    private String buildingarea;
    /**  */
    private String yearofpropertyrights;
    /**  */
    private String numplan;
    /**  */
    private String designtype;
    /**  */
    private String propertycompany;
    /**  */
    private String parkingratio;
    /**  */
    private String propertycosts;
    /**  */
    private String heatingmethod;
    /**  */
    private String watersupplymethod;
    /**  */
    private String powersupply;
    /**  */
    private String parkingspace;
    /**  */
    private String nearby;
    /**  */
    private String area;
    /**  */
    private String id;

    public InfodataEntity() {}

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
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
    public String getXiaoqu(){
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu){
        this.xiaoqu = xiaoqu;
    }
    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }
    public String getTotal(){
        return total;
    }

    public void setTotal(String total){
        this.total = total;
    }
    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }
    public String getPropertytype(){
        return propertytype;
    }

    public void setPropertytype(String propertytype){
        this.propertytype = propertytype;
    }
    public String getReferenceprice(){
        return referenceprice;
    }

    public void setReferenceprice(String referenceprice){
        this.referenceprice = referenceprice;
    }
    public String getProjectfeatures(){
        return projectfeatures;
    }

    public void setProjectfeatures(String projectfeatures){
        this.projectfeatures = projectfeatures;
    }
    public String getRegionallocation(){
        return regionallocation;
    }

    public void setRegionallocation(String regionallocation){
        this.regionallocation = regionallocation;
    }
    public String getPropertyaddress(){
        return propertyaddress;
    }

    public void setPropertyaddress(String propertyaddress){
        this.propertyaddress = propertyaddress;
    }
    public String getSalesofficeaddress(){
        return salesofficeaddress;
    }

    public void setSalesofficeaddress(String salesofficeaddress){
        this.salesofficeaddress = salesofficeaddress;
    }
    public String getDeveloper(){
        return developer;
    }

    public void setDeveloper(String developer){
        this.developer = developer;
    }
    public String getBuildingtype(){
        return buildingtype;
    }

    public void setBuildingtype(String buildingtype){
        this.buildingtype = buildingtype;
    }
    public String getLandscapingratio(){
        return landscapingratio;
    }

    public void setLandscapingratio(String landscapingratio){
        this.landscapingratio = landscapingratio;
    }
    public String getSitearea(){
        return sitearea;
    }

    public void setSitearea(String sitearea){
        this.sitearea = sitearea;
    }
    public String getFloorarearatio(){
        return floorarearatio;
    }

    public void setFloorarearatio(String floorarearatio){
        this.floorarearatio = floorarearatio;
    }
    public String getBuildingarea(){
        return buildingarea;
    }

    public void setBuildingarea(String buildingarea){
        this.buildingarea = buildingarea;
    }
    public String getYearofpropertyrights(){
        return yearofpropertyrights;
    }

    public void setYearofpropertyrights(String yearofpropertyrights){
        this.yearofpropertyrights = yearofpropertyrights;
    }
    public String getNumplan(){
        return numplan;
    }

    public void setNumplan(String numplan){
        this.numplan = numplan;
    }
    public String getDesigntype(){
        return designtype;
    }

    public void setDesigntype(String designtype){
        this.designtype = designtype;
    }
    public String getPropertycompany(){
        return propertycompany;
    }

    public void setPropertycompany(String propertycompany){
        this.propertycompany = propertycompany;
    }
    public String getParkingratio(){
        return parkingratio;
    }

    public void setParkingratio(String parkingratio){
        this.parkingratio = parkingratio;
    }
    public String getPropertycosts(){
        return propertycosts;
    }

    public void setPropertycosts(String propertycosts){
        this.propertycosts = propertycosts;
    }
    public String getHeatingmethod(){
        return heatingmethod;
    }

    public void setHeatingmethod(String heatingmethod){
        this.heatingmethod = heatingmethod;
    }
    public String getWatersupplymethod(){
        return watersupplymethod;
    }

    public void setWatersupplymethod(String watersupplymethod){
        this.watersupplymethod = watersupplymethod;
    }
    public String getPowersupply(){
        return powersupply;
    }

    public void setPowersupply(String powersupply){
        this.powersupply = powersupply;
    }
    public String getParkingspace(){
        return parkingspace;
    }

    public void setParkingspace(String parkingspace){
        this.parkingspace = parkingspace;
    }
    public String getNearby(){
        return nearby;
    }

    public void setNearby(String nearby){
        this.nearby = nearby;
    }
    public String getArea(){
        return area;
    }

    public void setArea(String area){
        this.area = area;
    }
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "InfodataEntity{" +
            "date='" + date + '\'' + ", " + 
            "city='" + city + '\'' + ", " + 
            "region='" + region + '\'' + ", " + 
            "xiaoqu='" + xiaoqu + '\'' + ", " + 
            "price='" + price + '\'' + ", " + 
            "total='" + total + '\'' + ", " + 
            "url='" + url + '\'' + ", " + 
            "propertytype='" + propertytype + '\'' + ", " + 
            "referenceprice='" + referenceprice + '\'' + ", " + 
            "projectfeatures='" + projectfeatures + '\'' + ", " + 
            "regionallocation='" + regionallocation + '\'' + ", " + 
            "propertyaddress='" + propertyaddress + '\'' + ", " + 
            "salesofficeaddress='" + salesofficeaddress + '\'' + ", " + 
            "developer='" + developer + '\'' + ", " + 
            "buildingtype='" + buildingtype + '\'' + ", " + 
            "landscapingratio='" + landscapingratio + '\'' + ", " + 
            "sitearea='" + sitearea + '\'' + ", " + 
            "floorarearatio='" + floorarearatio + '\'' + ", " + 
            "buildingarea='" + buildingarea + '\'' + ", " + 
            "yearofpropertyrights='" + yearofpropertyrights + '\'' + ", " + 
            "numplan='" + numplan + '\'' + ", " + 
            "designtype='" + designtype + '\'' + ", " + 
            "propertycompany='" + propertycompany + '\'' + ", " + 
            "parkingratio='" + parkingratio + '\'' + ", " + 
            "propertycosts='" + propertycosts + '\'' + ", " + 
            "heatingmethod='" + heatingmethod + '\'' + ", " + 
            "watersupplymethod='" + watersupplymethod + '\'' + ", " + 
            "powersupply='" + powersupply + '\'' + ", " + 
            "parkingspace='" + parkingspace + '\'' + ", " + 
            "nearby='" + nearby + '\'' + ", " + 
            "area='" + area + '\'' + ", " + 
            "id='" + id + '\'' +
        '}';
    }
}
