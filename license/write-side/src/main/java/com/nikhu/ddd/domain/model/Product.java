package com.nikhu.ddd.domain.model;

/**
 * Created by vravuri on 10-Jul-17.
 */
public class Product {
    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
