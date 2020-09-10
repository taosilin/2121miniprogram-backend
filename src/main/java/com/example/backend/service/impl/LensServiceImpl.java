package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.LensMapper;
import com.example.backend.model.Lens;
import com.example.backend.service.LensService;
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
public class LensServiceImpl extends AbstractService<Lens> implements LensService{
    @Resource
    private LensMapper lensMapper;

    public void addLens(Lens l){
        lensMapper.addLens(l);
    }
}
