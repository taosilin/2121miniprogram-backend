package com.example.backend.model;

import javax.persistence.*;

public class LensStock {
    private String lensID;

    private Double SPH;

    private Double CYL;

    private Integer stock;

    public String getLensID() {
        return lensID;
    }

    public void setLensID(String lensID) {
        this.lensID = lensID;
    }

    public Double getSPH() {
        return SPH;
    }

    public void setSPH(Double SPH) {
        this.SPH = SPH;
    }

    public Double getCYL() {
        return CYL;
    }

    public void setCYL(Double CYL) {
        this.CYL = CYL;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
