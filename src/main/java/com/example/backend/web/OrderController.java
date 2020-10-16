package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Order;
import com.example.backend.service.OrderService;
import com.example.backend.web.model.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @PostMapping("/list")
    public Result orderList(@RequestBody MyRequestBody myRequestBody){
        List<Order> list = orderService.orderList(myRequestBody.sortedBy, myRequestBody.page, myRequestBody.size);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/update")
    public Result updateOrder(@RequestBody Order o){
        orderService.updateOrder(o);
        return ResultGenerator.genSuccessResult();
    }

    //订单待办预警
    @PostMapping("/pending")
    public Result orderPending(){
        OrderPending orderPending = orderService.orderPending();
        return ResultGenerator.genSuccessResult(orderPending);
    }

//    @PostMapping("/findByDate")
//    public Result findByDate(@RequestBody String orderTime){
//        //日期格式转换
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = null;
//        try{
//            date = simpleDateFormat.parse(orderTime);
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        List<Order> list = orderService.findByDate(date);
//        return ResultGenerator.genSuccessResult(list);
//    }

    //今日交易看板
    @PostMapping("/transaction")
    public Result transactionBoard(){
        TransactionBoard transactionBoard = orderService.transactionBoard();

        return ResultGenerator.genSuccessResult(transactionBoard);
    }

    //订单统计
    @PostMapping("/statistics")
    public Result orderStatistics(){
        List<OrderStatistics> list = orderService.orderStatistics();
        return ResultGenerator.genSuccessResult(list);
    }
}
