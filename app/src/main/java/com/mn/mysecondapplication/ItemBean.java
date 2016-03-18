package com.mn.mysecondapplication;

import java.io.Serializable;

public class ItemBean implements Serializable{
    public int image;
    public String name;
    public String sex;
    public String major;

    public ItemBean(int image, String name, String sex,String major) {
        this.image=image;
        this.name=name;
        this.sex=sex;
        this.major=major;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

}


