package com.raising.modules.buildingPrice.entity;

import com.raising.framework.entity.BaseEntity;

/**
* 
* @author fsd
* @createTime 2019-03-20 14:38:23
*/
public class LoupanPicEntity extends BaseEntity<LoupanPicEntity>{

    /**  */
    private String id;
    /**  */
    private String num;
    /**  */
    private String url;
    /**  */
    private String type;
    /**  */
    private String pic;

    public LoupanPicEntity() {}

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getNum(){
        return num;
    }

    public void setNum(String num){
        this.num = num;
    }
    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }
    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getPic(){
        return pic;
    }

    public void setPic(String pic){
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "LoupanPicEntity{" +
            "id='" + id + '\'' + ", " + 
            "num='" + num + '\'' + ", " + 
            "url='" + url + '\'' + ", " + 
            "type='" + type + '\'' + ", " + 
            "pic='" + pic + '\'' +
        '}';
    }
}
