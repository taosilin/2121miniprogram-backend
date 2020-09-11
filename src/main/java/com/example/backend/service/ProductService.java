package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Product;
import com.example.backend.web.model.ProductDetail;

public interface ProductService extends Service<Product> {
    void addProduct(Product p);
    ProductDetail productDetail(String productID);
    void updateProduct (Product p);
}
