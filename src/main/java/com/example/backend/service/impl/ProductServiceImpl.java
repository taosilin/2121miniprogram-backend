package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.AttributeMapper;
import com.example.backend.dao.ProductMapper;
import com.example.backend.dao.SpecMapper;
import com.example.backend.dao.ValueMapper;
import com.example.backend.model.Attribute;
import com.example.backend.model.Product;
import com.example.backend.service.ProductService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

import com.example.backend.web.model.ProductDetail;
import com.example.backend.web.model.ValueList;
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
    @Resource
    private AttributeMapper attributeMapper;
    @Resource
    private ValueMapper valueMapper;
    @Resource
    private SpecMapper specMapper;

    public void addProduct(Product p){
        productMapper.addProduct(p);
    }

    public ProductDetail productDetail(String productID){
        ProductDetail p = new ProductDetail();
        List<ValueList> valueLists = new ArrayList<>();
        p.specs=specMapper.specList(productID);
        p.product = productMapper.productDetail(productID);
        List<Attribute> attributes = attributeMapper.attributeList(productID);
        for (Attribute a:attributes){
            ValueList valueList = new ValueList();
            valueList.attribute = a;
            valueList.values = valueMapper.valueList(a.getAttributeID());
            valueLists.add(valueList);
        }
        p.attributes = valueLists;
        return p;
    }

    public void updateProduct(Product p){
        productMapper.updateProduct(p);
    }
}
