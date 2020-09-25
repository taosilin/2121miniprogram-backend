package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.FrameLensMapper;
import com.example.backend.model.FrameLens;
import com.example.backend.model.Lens;
import com.example.backend.service.FrameLensService;
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
public class FrameLensServiceImpl extends AbstractService<FrameLens> implements FrameLensService{
    @Resource
    private FrameLensMapper frameLensMapper;

    public void addFrameLens(FrameLens f){
        frameLensMapper.addFrameLens(f);
    }

    public List<Lens> lensList(String frameID){
        return frameLensMapper.lensList(frameID);
    }

    public void deleteFrameLens(FrameLens f){
        frameLensMapper.deleteFrameLens(f);
    }
}
