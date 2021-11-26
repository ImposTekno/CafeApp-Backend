package com.ImposTekno.CafeApp.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long Id;
    private String productName;
    private String productInfo;
    private float productPrice;
    @Column(columnDefinition = "integer default 0")
    private int rating;

    private String imgUrl;

    // Will be implemented in future
    //private User productCreator;


    //Constructor
    public Product(String _productName, String _productInfo, float _productPrice, String _imgUrl)
    {
        this.productName= _productName;
        this.productInfo = _productInfo;
        this.productPrice = _productPrice;
        this.imgUrl = _imgUrl;
    }

    // Default constructor
    public Product()
    {

    }
    //Setters for product item


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public void setImgUrl(String _imgUrl) {
        this.imgUrl = _imgUrl;
    }

    public void setRating(int rating) {
        // Basic check to prevent rating to be lower than 0 and greater than 5
        if(rating >=0 && rating <=5) {
            this.rating = rating;

        }

    }

    //Getters for product item :)
    public Long getId()
    {
        return this.Id;
    }
    public String getProductName()
    {
        return this.productName;
    }
    public String getProductInfo()
    {
        return this.productInfo;
    }
    public float getProductPrice()
    {
        return this.productPrice;
    }
    public int getRating()
    {
        return this.rating;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }
}
