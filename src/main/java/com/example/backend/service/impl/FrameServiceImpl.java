package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.FrameMapper;
import com.example.backend.model.Frame;
import com.example.backend.service.FrameService;
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
public class FrameServiceImpl extends AbstractService<Frame> implements FrameService{
    @Resource
    private FrameMapper frameMapper;

    public void addFrame(Frame f){
        frameMapper.addFrame(f);
    }

    public List<Frame> frameList(Integer page,Integer size){
        return frameMapper.frameList(page*size,size);
    }
}
