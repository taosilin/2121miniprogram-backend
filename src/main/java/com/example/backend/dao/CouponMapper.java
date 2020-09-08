package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Coupon;
import org.apache.ibatis.annotations.Param;

public interface CouponMapper extends Mapper<Coupon>{
    public void addCoupon(Coupon c);
}
