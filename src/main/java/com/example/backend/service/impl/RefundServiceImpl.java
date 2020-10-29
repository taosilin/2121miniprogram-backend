package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.RefundMapper;
import com.example.backend.model.Refund;
import com.example.backend.service.RefundService;
import com.example.backend.core.AbstractService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RefundServiceImpl extends AbstractService<Refund> implements RefundService{
    @Resource
    private RefundMapper refundMapper;

    public void addRefund(Refund r) {
        refundMapper.addRefund(r);
    }

    public List<Refund> refundList(Integer page,Integer size){
        return refundMapper.refundList(page*size, size);
    }

    public Integer refundTotal(){
        return refundMapper.refundTotal();
    }

}
