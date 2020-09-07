package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.ProductMapper;
import com.example.backend.model.Product;
import com.example.backend.service.ProductService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class ProductServiceImpl extends AbstractService<Product> implements ProductService{
    @Resource
    private ProductMapper productMapper;

    public void addProduct(Product p){
        productMapper.addProduct(p);
    }
}
