package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Spec;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface SpecMapper extends Mapper<Spec> {
    public void addSpec(Spec s);
    public List<Spec> specList(@Param("productID") String productID);
}
