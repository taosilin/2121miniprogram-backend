package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.LensStockMapper;
import com.example.backend.model.LensStock;
import com.example.backend.service.LensStockService;
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
public class LensStockServiceImpl extends AbstractService<LensStock> implements LensStockService{
    @Resource
    private LensStockMapper lensStockMapper;

    public void addLensStock(LensStock l){
        lensStockMapper.addLensStock(l);
    }

    public void updateLensStock(LensStock l){
        lensStockMapper.updateLensStock(l);
    }

    public void deleteLensStock(String stockID){
        lensStockMapper.deleteLensStock(stockID);
    }

    public List<LensStock> stockList(String lensID){
        return lensStockMapper.stockList(lensID);
    }
}
