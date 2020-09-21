package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper extends Mapper<Admin>{
    public Admin adminLogin(@Param("adminID")String adminID);
}
