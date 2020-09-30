package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.ClassMapper;
import com.example.backend.model.Class;
import com.example.backend.service.ClassService;
import com.example.backend.core.AbstractService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ClassServiceImpl extends AbstractService<Class> implements ClassService{
    @Resource
    private ClassMapper classMapper;

    public void addClass(Class c){
        classMapper.addClass(c);
    }

    public void updateClass(Class c){
        classMapper.updateClass(c);
    }

    public void deleteClass(Integer classID){
        classMapper.deleteClass(classID);
    }

    public List<Class> classList(Integer page,Integer size){
        return classMapper.classList(page*size, size);
    }
}
