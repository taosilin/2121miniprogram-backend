package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.LensStockMapper;
import com.example.backend.dao.SpecMapper;
import com.example.backend.model.Spec;
import com.example.backend.service.SpecService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

import com.example.backend.web.model.StockWarning;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class SpecServiceImpl extends AbstractService<Spec> implements SpecService{
    @Resource
    private SpecMapper specMapper;

    @Resource
    private LensStockMapper lensStockMapper;

    public void addSpec(Spec s){
        specMapper.addSpec(s);
    }

    public void deleteSpec(String specID){
        specMapper.deleteSpec(specID);
    }

    public void updateSpec(Spec s){
        specMapper.updateSpec(s);
    }

    public StockWarning stockWarning(){
        StockWarning stockWarning = new StockWarning();
        stockWarning.lensWarning = lensStockMapper.lensStockWarning().size();
        stockWarning.productWarning = specMapper.productWarning().size();
        return stockWarning;
    }
}
