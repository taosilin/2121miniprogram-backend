package com.example.backend.web.model;

import com.example.backend.model.Coupon;

import java.util.ArrayList;
import java.util.List;

public class CouponList {
    public List<Coupon> enabledCoupons = new ArrayList<>();
    public List<Coupon> disabledCoupons = new ArrayList<>();
}
