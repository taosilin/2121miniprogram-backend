package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Order;
import com.example.backend.service.OrderService;
import com.example.backend.web.model.MyRequestBody;
import com.example.backend.web.model.OrderRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @PostMapping("/add")
    public Result addOrder(@RequestBody OrderRequest orderRequest){
        orderService.addOrder(orderRequest);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result orderDetail(@RequestBody Order order){
        OrderRequest orderRequest = orderService.orderDetail(order.getOrderID());
        return ResultGenerator.genSuccessResult(orderRequest);
    }

    @PostMapping("/userlist")
    public Result userOrderList(@RequestBody Order order){
        List<OrderRequest> list = orderService.userOrderList(order.getUserID());
        return ResultGenerator.genSuccessResult(list);
    }
}
