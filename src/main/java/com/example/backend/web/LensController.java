package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Lens;
import com.example.backend.service.LensService;
import com.example.backend.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/lens")
public class LensController {
    @Resource
    private LensService lensService;

    @PostMapping("/add")
    public Result addLens(@RequestBody Lens lens){
        lensService.addLens(lens);
        return ResultGenerator.genSuccessResult();
    }
}
