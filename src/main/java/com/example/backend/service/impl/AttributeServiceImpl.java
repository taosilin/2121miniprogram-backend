package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.AttributeMapper;
import com.example.backend.model.Attribute;
import com.example.backend.service.AttributeService;
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
public class AttributeServiceImpl extends AbstractService<Attribute> implements AttributeService{
    @Resource
    private AttributeMapper attributeMapper;

    public void addAttribute(Attribute a){
        attributeMapper.addAttribute(a);
    }
}
