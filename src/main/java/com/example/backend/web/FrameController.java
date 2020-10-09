package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Frame;
import com.example.backend.service.FrameService;
import com.example.backend.web.model.FrameDetail;
import com.example.backend.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
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

    @PostMapping("/list")
    public Result frameList(@RequestBody MyRequestBody myRequestBody){
        List<Frame> list = frameService.frameList(myRequestBody.page,myRequestBody.size);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/detail")
    public Result findByFrameID(@RequestBody Frame f){
        FrameDetail frameDetail = frameService.findByFrameID(f.getFrameID());
        return ResultGenerator.genSuccessResult(frameDetail);
    }

    @PostMapping("/update")
    public Result updateFrame(@RequestBody Frame f){
        frameService.updateFrame(f);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteFrame(@RequestBody Frame f){
        frameService.deleteFrame(f.getFrameID());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/overview")
    public Result frameOverview(){
        return ResultGenerator.genSuccessResult(frameService.frameOverview());
    }
}
