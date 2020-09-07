package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Product;

public interface ProductService extends Service<Product> {
    void addProduct(Product p);
}
