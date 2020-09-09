package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Spec;
import com.example.backend.service.SpecService;
import com.example.backend.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/spec")
public class SpecController {
    @Resource
    private SpecService specService;

    @PostMapping("/add")
    public Result addSpec(@RequestBody Spec spec){
        specService.addSpec(spec);
        return ResultGenerator.genSuccessResult();
    }
}
