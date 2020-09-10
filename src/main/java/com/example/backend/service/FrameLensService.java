package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.FrameLens;
import com.example.backend.model.Lens;

import java.util.List;

public interface FrameLensService extends Service<FrameLens> {
    void addFrameLens(FrameLens f);
    List<Lens> lensList(String frameID);
}
