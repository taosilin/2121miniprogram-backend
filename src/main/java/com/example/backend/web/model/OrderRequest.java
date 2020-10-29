package com.example.backend.web.model;

import com.example.backend.model.Order;
import com.example.backend.model.OrderFrame;
import com.example.backend.model.OrderProduct;
import com.example.backend.model.Refund;

import java.util.List;

public class OrderRequest {
    public Order order;
    public List<OrderProductResult> products;
    public List<OrderFrameResult> frames;
    public Refund refund;
}
