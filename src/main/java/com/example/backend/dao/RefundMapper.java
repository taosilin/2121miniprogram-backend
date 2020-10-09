package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Refund;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RefundMapper extends Mapper<Refund> {
    public void addRefund(Refund r);
    public List<Refund> refundList(@Param("page")Integer page,@Param("size")Integer size);

}
