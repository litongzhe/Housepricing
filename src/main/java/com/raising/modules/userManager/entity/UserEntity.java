package com.raising.modules.userManager.entity;

import com.raising.framework.entity.BaseEntity;

/**
* 
* @author fsd
* @createTime 2019-02-27 11:09:34
*/
public class UserEntity extends BaseEntity<UserEntity>{

    /**  */
    private String id;
    /**  */
    private String name;
    /**  */
    private String tel;
    /**  */
    private String password;

    public UserEntity() {}

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getTel(){
        return tel;
    }

    public void setTel(String tel){
        this.tel = tel;
    }
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
            "id='" + id + '\'' + ", " + 
            "name='" + name + '\'' + ", " + 
            "tel='" + tel + '\'' + ", " + 
            "password='" + password + '\'' +
        '}';
    }
}
