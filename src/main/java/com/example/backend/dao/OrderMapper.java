package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Order;

public interface OrderMapper extends Mapper<Order> {
    public void addOrder(Order o);
}
