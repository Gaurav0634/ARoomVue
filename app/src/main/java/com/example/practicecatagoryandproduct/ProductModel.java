package com.example.practicecatagoryandproduct;

public class ProductModel {

    String title, price, glbFileLocation;
    int img;



    public ProductModel(String title, String price, int img, String glbFileLocation){
        this.title = title;
        this.price = price;
        this.img = img;
        this.glbFileLocation = glbFileLocation;
    }
}
