package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.LensStock;
import com.example.backend.service.LensStockService;
import com.example.backend.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/lensstock")
public class LensStockController {
    @Resource
    private LensStockService lensStockService;

    @PostMapping("/add")
    public Result addLensStock(@RequestBody LensStock lensStock){
        lensStockService.addLensStock(lensStock);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result updateLensStock(@RequestBody LensStock lensStock){
        lensStockService.updateLensStock(lensStock);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteLensStock(@RequestBody LensStock lensStock){
        lensStockService.deleteLensStock(lensStock.getStockID());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result stockList(@RequestBody LensStock lensStock){
        List<LensStock> list = lensStockService.stockList(lensStock.getLensID());
        return ResultGenerator.genSuccessResult(list);
    }
}
