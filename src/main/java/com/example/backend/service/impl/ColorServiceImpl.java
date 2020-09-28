package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.ColorMapper;
import com.example.backend.model.Color;
import com.example.backend.service.ColorService;
import com.example.backend.core.AbstractService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ColorServiceImpl extends AbstractService<Color> implements ColorService{
    @Resource
    private ColorMapper colorMapper;

    public void addColor(Color c){
        colorMapper.addColor(c);
    }

    public List<Color> colorList(Integer page,Integer size){
        return colorMapper.colorList(page*size, size);
    }

    public void updateColor(Color c){
        colorMapper.updateColor(c);
    }

    public void deleteColor(Integer colorID){
        colorMapper.deleteColor(colorID);
    }
}
