package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.AttributeMapper;
import com.example.backend.dao.FrameMapper;
import com.example.backend.dao.SpecMapper;
import com.example.backend.dao.ValueMapper;
import com.example.backend.model.Attribute;
import com.example.backend.model.Frame;
import com.example.backend.service.FrameService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

import com.example.backend.web.model.FrameDetail;
import com.example.backend.web.model.ValueList;
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
    @Resource
    private AttributeMapper attributeMapper;
    @Resource
    private ValueMapper valueMapper;
    @Resource
    private SpecMapper specMapper;

    public void addFrame(Frame f){
        frameMapper.addFrame(f);
    }

    public List<Frame> frameList(Integer page,Integer size){
        return frameMapper.frameList(page*size,size);
    }

    public FrameDetail findByFrameID(String frameID){
        FrameDetail f = new FrameDetail();
        List<ValueList> valueLists = new ArrayList<>();
        f.specs=specMapper.specList(frameID);
        f.frame = frameMapper.findByFrameID(frameID);
        List<Attribute> attributes = attributeMapper.attributeList(frameID);
        for (Attribute a:attributes){
            ValueList valueList = new ValueList();
            valueList.attribute = a;
            valueList.values = valueMapper.valueList(a.getAttributeID());
            valueLists.add(valueList);
        }
        f.attributes = valueLists;
        return f;
    }

    public void updateFrame(Frame f){
        frameMapper.updateFrame(f);
    }

    public void deleteFrame(String frameID){
        frameMapper.deleteFrame(frameID);
    }
}
