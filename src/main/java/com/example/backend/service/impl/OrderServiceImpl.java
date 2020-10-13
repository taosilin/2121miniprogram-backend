package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.OrderFrameMapper;
import com.example.backend.dao.OrderMapper;
import com.example.backend.dao.OrderProductMapper;
import com.example.backend.model.Order;
import com.example.backend.model.OrderFrame;
import com.example.backend.model.OrderProduct;
import com.example.backend.service.OrderService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

import com.example.backend.web.model.OrderPending;
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

    @Resource
    private OrderFrameMapper orderFrameMapper;

    public void addOrder(OrderRequest o){
        orderMapper.addOrder(o.order);
        for (OrderProduct product:o.products){
            orderProductMapper.addOrderProduct(product);
        }
        for (OrderFrame frame:o.frames){
            orderFrameMapper.addOrderFrame(frame);
        }
    }

    public OrderRequest orderDetail(String orderID){
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.order = orderMapper.findByOrderID(orderID);
        orderRequest.products = orderProductMapper.findOrderProduct(orderID);
        orderRequest.frames = orderFrameMapper.findOrderFrame(orderID);
        return orderRequest;
    }

    public List<OrderRequest> userOrderList(String userID){
        List<OrderRequest> orderRequests = new ArrayList<>();
        List<Order> orders = orderMapper.findByUserID(userID);
        for (Order order:orders){
            OrderRequest orderRequest = new OrderRequest();
            orderRequest.order = order;
            orderRequest.products = orderProductMapper.findOrderProduct(order.getOrderID());
            orderRequest.frames = orderFrameMapper.findOrderFrame(order.getOrderID());
            orderRequests.add(orderRequest);
        }
        return orderRequests;
    }

    public List<Order> orderList(String state,Integer page,Integer size){
        if (state.equals("0")) return orderMapper.orderList(page*size,size);
        else return orderMapper.stateFilter(state,page*size,size);
    }

    public void updateOrder(Order o){
        orderMapper.updateOrder(o);
    }

    public OrderPending orderPending(){
        OrderPending orderPending = new OrderPending();
        orderPending.toBeReviewed = orderMapper.stateOrderNum("2");
        orderPending.toBeDelivered = orderMapper.stateOrderNum("3");
        return orderPending;
    }
}
