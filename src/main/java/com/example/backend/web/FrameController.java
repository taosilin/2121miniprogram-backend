package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Frame;
import com.example.backend.service.FrameService;
import com.example.backend.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/frame")
public class FrameController {
    @Resource
    private FrameService frameService;

    @PostMapping("/add")
    public Result addFrame(@RequestBody Frame frame){
        frameService.addFrame(frame);
        return ResultGenerator.genSuccessResult();
    }
}
