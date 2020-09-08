package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Coupon;
import com.example.backend.model.UserCoupon;

import java.util.List;

public interface UserCouponService extends Service<UserCoupon> {
    void getCoupon(UserCoupon u);
    List<Coupon> couponList(String userID);
}
