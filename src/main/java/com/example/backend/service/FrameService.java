package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Frame;
import com.example.backend.web.model.FrameDetail;
import com.example.backend.web.model.ProductOverview;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FrameService extends Service<Frame> {
    void addFrame(Frame f);
    List<Frame> frameList(Integer page,Integer size);
    FrameDetail findByFrameID(String frameID);
    void updateFrame(Frame f);
    void deleteFrame(String frameID);
    ProductOverview frameOverview();
    Integer frameTotal();
    String saveImage(MultipartFile imageFile) throws Exception;
    List<Frame> searchByFrameName(String searchString);
    List<Frame> findByFrameClass(String classification,Integer page,Integer size);
}
