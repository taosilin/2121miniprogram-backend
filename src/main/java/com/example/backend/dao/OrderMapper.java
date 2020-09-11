package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper extends Mapper<Order> {
    public void addOrder(Order o);
    public Order findByOrderID(@Param("orderID") String orderID);
    public List<Order> findByUserID(@Param("userID") String userID);
}
