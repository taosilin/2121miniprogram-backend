package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.CartMapper;
import com.example.backend.model.Cart;
import com.example.backend.service.CartService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class CartServiceImpl extends AbstractService<Cart> implements CartService{
    @Resource
    private CartMapper cartMapper;

    public void addCart(Cart c){
        cartMapper.addCart(c);
    }

    public void deleteCart(Cart c){
        cartMapper.deleteCart(c);
    }
}
