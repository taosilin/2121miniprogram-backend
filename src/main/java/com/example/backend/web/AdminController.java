package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Admin;
import com.example.backend.service.AdminService;
import com.example.backend.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @PostMapping("/login")
    public Result adminLogin(@RequestBody Admin a){
        Admin admin = adminService.adminLogin(a.getAdminID());
        if (admin.getPassword().equals(a.getPassword())){
            return ResultGenerator.genSuccessResult("登录成功！");
        }
        else {
            return ResultGenerator.genFailResult("用户名或密码错误");
        }
    }

    @PostMapping("/list")
    public Result adminList(@RequestBody MyRequestBody myRequestBody){
        List<Admin> list = adminService.adminList(myRequestBody.page, myRequestBody.size);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/add")
    public Result addAdmin(@RequestBody Admin admin){
        adminService.addAdmin(admin);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteAdmin(@RequestBody Admin admin){
        adminService.deleteAdmin(admin.getAdminID());
        return ResultGenerator.genSuccessResult();
    }
}
