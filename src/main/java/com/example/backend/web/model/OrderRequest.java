package com.example.backend.web.model;

import com.example.backend.model.Order;
import com.example.backend.model.OrderFrame;
import com.example.backend.model.OrderProduct;

import java.util.List;

public class OrderRequest {
    public Order order;
    public List<OrderProduct> products;
    public List<OrderFrame> frames;
}
