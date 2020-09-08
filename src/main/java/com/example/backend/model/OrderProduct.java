package com.example.backend.model;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.persistence.*;

public class OrderProduct {
    @Id
    private String orderID;

    private String productID;

    private String specID;

    private String state;

    private Integer num;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getSpecID() {
        return specID;
    }

    public void setSpecID(String specID) {
        this.specID = specID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
