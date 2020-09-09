package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Value;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ValueMapper extends Mapper<Value> {
    public void addValue(Value v);
    public List<Value> valueList(@Param("attributeID") String attributeID);
}
