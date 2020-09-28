package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Color;

import java.util.List;

public interface ColorService extends Service<Color> {
    void addColor(Color c);
    List<Color> colorList(Integer page,Integer size);
    void updateColor(Color c);
    void deleteColor(Integer colorID);
}
