package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.LensStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LensStockMapper extends Mapper<LensStock> {
    public void addLensStock(LensStock l);
    public void updateLensStock(LensStock l);
    public void deleteLensStock(@Param("stockID")String stockID);
    public List<LensStock> stockList(@Param("lensID")String lensID);
}
