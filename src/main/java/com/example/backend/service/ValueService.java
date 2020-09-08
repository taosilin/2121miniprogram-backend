package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Value;

public interface ValueService extends Service<Value> {
    void addValue(Value v);
}
