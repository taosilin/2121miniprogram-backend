package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Frame;

public interface FrameService extends Service<Frame> {
    void addFrame(Frame f);
}
