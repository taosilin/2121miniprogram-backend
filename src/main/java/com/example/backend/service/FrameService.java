package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Frame;

import java.util.List;

public interface FrameService extends Service<Frame> {
    void addFrame(Frame f);
    List<Frame> frameList(Integer page,Integer size);
}
