package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Attribute;

public interface AttributeService extends Service<Attribute> {
    void addAttribute(Attribute a);
}
