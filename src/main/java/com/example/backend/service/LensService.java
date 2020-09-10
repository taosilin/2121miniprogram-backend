package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Lens;

public interface LensService extends Service<Lens> {
    void addLens(Lens l);
}
