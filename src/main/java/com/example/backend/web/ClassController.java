package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Class;
import com.example.backend.service.ClassService;
import com.example.backend.web.model.MyRequestBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Resource
    private ClassService classService;

    @PostMapping("/add")
    public Result addClass(@RequestBody Class c){
        classService.addClass(c);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result updateClass(@RequestBody Class c){
        classService.updateClass(c);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteClass(@RequestBody Class c){
        classService.deleteClass(c.getClassID());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result classList(@RequestBody MyRequestBody myRequestBody){
        List<Class> list = classService.classList(myRequestBody.page, myRequestBody.size);
        return ResultGenerator.genSuccessResult(list);
    }
}
