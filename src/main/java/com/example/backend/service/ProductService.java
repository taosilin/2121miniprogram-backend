package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Product;
import com.example.backend.web.model.ProductDetail;
import com.example.backend.web.model.ProductOverview;

import java.util.List;

public interface ProductService extends Service<Product> {
    void addProduct(Product p);
    ProductDetail productDetail(String productID);
    void updateProduct (Product p);
    List<Product> productList(Integer page,Integer size);
    ProductOverview productOverview();
}
