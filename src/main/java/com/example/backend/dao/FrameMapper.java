package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Frame;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FrameMapper extends Mapper<Frame> {
    public void addFrame(Frame f);
    public List<Frame> frameList(@Param("page")Integer page, @Param("size")Integer size);
}
