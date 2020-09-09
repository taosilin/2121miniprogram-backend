package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Attribute;
import com.example.backend.model.Value;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttributeMapper extends Mapper<Attribute> {
    public void addAttribute(Attribute a);
    public List<Attribute> attributeList(@Param("productID") String productID);
}
