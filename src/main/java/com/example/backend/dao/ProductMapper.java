package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper extends Mapper<Product> {
    public void addProduct(Product p);
    public Product productDetail(@Param("productID") String productID);
}
