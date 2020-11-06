package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Cart;

public interface CartService extends Service<Cart> {
    void addCart(Cart c);
    void deleteCart(Cart c);
    void updateCart(Cart c);
}
