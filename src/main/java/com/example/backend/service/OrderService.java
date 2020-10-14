package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Order;
import com.example.backend.web.model.OrderPending;
import com.example.backend.web.model.OrderRequest;

import java.util.Date;
import java.util.List;

public interface OrderService extends Service<Order> {
    void addOrder(OrderRequest o);
    OrderRequest orderDetail(String orderID);
    List<OrderRequest> userOrderList(String userID);
    List<Order> orderList(String state,Integer page,Integer size);
    void updateOrder(Order o);
    OrderPending orderPending();
    List<Order> findByDate(Date orderTime);
}
