package com.example.backend.model;

import javax.persistence.*;

public class Lens {
    @Id
    private String lensID;

    private String lensName;

    private Double price;

    private String refractiveIndex;

    private String material;

    private String radian;

    private String variety;

    private String film;

    private String design;

    private String state;

    private Integer stock;

    private String description;

    public String getLensID() {
        return lensID;
    }

    public void setLensID(String lensID) {
        this.lensID = lensID;
    }

    public String getLensName() {
        return lensName;
    }

    public void setLensName(String lensName) {
        this.lensName = lensName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRefractiveIndex() {
        return refractiveIndex;
    }

    public void setRefractiveIndex(String refractiveIndex) {
        this.refractiveIndex = refractiveIndex;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getRadian() {
        return radian;
    }

    public void setRadian(String radian) {
        this.radian = radian;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
