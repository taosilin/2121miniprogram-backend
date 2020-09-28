package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Color;
import com.example.backend.service.ColorService;
import com.example.backend.web.model.MyRequestBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/color")
public class ColorController {
    @Resource
    private ColorService colorService;

    @PostMapping("/add")
    public Result addColor(@RequestBody Color color){
        colorService.addColor(color);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result colorList(@RequestBody MyRequestBody myRequestBody){
        List<Color> list = colorService.colorList(myRequestBody.page, myRequestBody.size);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/update")
    public Result updateColor(@RequestBody Color color){
        colorService.updateColor(color);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteColor(@RequestBody Color color){
        colorService.deleteColor(color.getColorID());
        return ResultGenerator.genSuccessResult();
    }
}
