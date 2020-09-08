package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.core.AbstractService;
import com.example.backend.dao.UserCouponMapper;
import com.example.backend.model.Coupon;
import com.example.backend.model.UserCoupon;
import com.example.backend.service.UserCouponService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@Service
@Transactional
public class UserCouponServiceImpl extends AbstractService<UserCoupon> implements UserCouponService {
    @Resource
    private UserCouponMapper userCouponMapper;

    public void getCoupon(UserCoupon u){
        userCouponMapper.getCoupon(u);
    }

    public List<Coupon> couponList(String userID){
        return userCouponMapper.couponList(userID);
    }
}
