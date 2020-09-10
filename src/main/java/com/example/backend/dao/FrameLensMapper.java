package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.FrameLens;
import com.example.backend.model.Lens;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FrameLensMapper extends Mapper<FrameLens> {
    public void addFrameLens(FrameLens f);
    public List<Lens> lensList(@Param("frameID")String frameID);
}
