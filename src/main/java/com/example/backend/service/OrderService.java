package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Order;
import com.example.backend.web.model.OrderRequest;

import java.util.List;

public interface OrderService extends Service<Order> {
    void addOrder(OrderRequest o);
    OrderRequest orderDetail(String orderID);
    List<OrderRequest> userOrderList(String userID);
}
