package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Frame;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FrameMapper extends Mapper<Frame> {
    public void addFrame(Frame f);
    public List<Frame> frameList(@Param("page")Integer page, @Param("size")Integer size);
    public Frame findByFrameID(@Param("frameID") String frameID);
    public void updateFrame(Frame f);
    public void deleteFrame(@Param("frameID")String frameID);
    public Integer frameNum(@Param("state")String state);
    public Integer frameTotal();
    public List<Frame> searchByFrameName(@Param("searchString")String searchString);
    public List<Frame> findByFrameClass(@Param("classification")String classification,@Param("page")Integer page, @Param("size")Integer size); // 按分类筛选镜框
}
