package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Spec;

public interface SpecService extends Service<Spec> {
    void addSpec(Spec s);
    void deleteSpec(String specID);
    void updateSpec(Spec s);
}
