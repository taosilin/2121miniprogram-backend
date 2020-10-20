package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Spec;
import com.example.backend.web.model.StockWarning;

public interface SpecService extends Service<Spec> {
    void addSpec(Spec s);
    void deleteSpec(String specID);
    void updateSpec(Spec s);
    StockWarning stockWarning(); // 库存不足的商品SKU
}
