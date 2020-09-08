package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Coupon;

public interface CouponService extends Service<Coupon> {
    void addCoupon(Coupon c);
}
