package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.OrderMapper;
import com.example.backend.dao.OrderProductMapper;
import com.example.backend.model.Order;
import com.example.backend.model.OrderProduct;
import com.example.backend.service.OrderService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

import com.example.backend.web.model.OrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class OrderServiceImpl extends AbstractService<Order> implements OrderService{
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderProductMapper orderProductMapper;

    public void addOrder(OrderRequest o){
        orderMapper.addOrder(o.order);
        for (OrderProduct product:o.products){
            orderProductMapper.addOrderProduct(product);
        }
    }
}
