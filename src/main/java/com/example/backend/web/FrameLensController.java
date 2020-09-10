package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.FrameLens;
import com.example.backend.model.Lens;
import com.example.backend.service.FrameLensService;
import com.example.backend.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/framelens")
public class FrameLensController {
    @Resource
    private FrameLensService frameLensService;

    @PostMapping("/add")
    public Result addFrameLens(@RequestBody FrameLens frameLens){
        frameLensService.addFrameLens(frameLens);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result lensList(@RequestBody FrameLens frameLens){
        List<Lens> list = frameLensService.lensList(frameLens.getFrameID());
        return ResultGenerator.genSuccessResult(list);
    }
}