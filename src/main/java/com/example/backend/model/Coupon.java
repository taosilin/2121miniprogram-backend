package com.example.backend.model;

import javax.persistence.*;

public class Coupon {
    @Id
    private String couponID;

    private String couponName;

    private Double restriction;

    private Double discount;

    private String description;

    private String productType;

    private Integer timeLimit;

    public String getCouponID() {
        return couponID;
    }

    public void setCouponID(String couponID) {
        this.couponID = couponID;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Double getRestriction() {
        return restriction;
    }

    public void setRestriction(Double restriction) {
        this.restriction = restriction;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
