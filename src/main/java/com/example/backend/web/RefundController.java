package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Refund;
import com.example.backend.service.RefundService;
import com.example.backend.web.model.MyRequestBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/refund")
public class RefundController {
    @Resource
    private RefundService refundService;

    @PostMapping("/add")
    public Result addRefund(@RequestBody Refund refund){
        refundService.addRefund(refund);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result refundList(@RequestBody MyRequestBody myRequestBody){
        List<Refund> list = refundService.refundList(myRequestBody.page, myRequestBody.size);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/total")
    public Integer refundTotal(){
        return refundService.refundTotal();
    }
}
