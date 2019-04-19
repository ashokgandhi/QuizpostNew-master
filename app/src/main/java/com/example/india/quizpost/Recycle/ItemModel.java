package com.example.india.quizpost.Recycle;

public class
ItemModel {


    public  int img;
    public String name;


    public ItemModel(int img, String name, String Packagename, String Description) {
        this.img = img;
        this.name = name;


    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
