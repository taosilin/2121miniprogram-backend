package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.OrderFrameMapper;
import com.example.backend.dao.OrderMapper;
import com.example.backend.dao.OrderProductMapper;
import com.example.backend.model.Order;
import com.example.backend.model.OrderFrame;
import com.example.backend.model.OrderProduct;
import com.example.backend.service.OrderService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.backend.web.model.OrderPending;
import com.example.backend.web.model.OrderRequest;
import com.example.backend.web.model.OrderStatistics;
import com.example.backend.web.model.TransactionBoard;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class OrderServiceImpl extends AbstractService<Order> implements OrderService{
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderProductMapper orderProductMapper;

    @Resource
    private OrderFrameMapper orderFrameMapper;

    public void addOrder(OrderRequest o){
        orderMapper.addOrder(o.order);
        for (OrderProduct product:o.products){
            orderProductMapper.addOrderProduct(product);
        }
        for (OrderFrame frame:o.frames){
            orderFrameMapper.addOrderFrame(frame);
        }
    }

    public OrderRequest orderDetail(String orderID){
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.order = orderMapper.findByOrderID(orderID);
        orderRequest.products = orderProductMapper.findOrderProduct(orderID);
        orderRequest.frames = orderFrameMapper.findOrderFrame(orderID);
        return orderRequest;
    }

    public List<OrderRequest> userOrderList(String userID){
        List<OrderRequest> orderRequests = new ArrayList<>();
        List<Order> orders = orderMapper.findByUserID(userID);
        for (Order order:orders){
            OrderRequest orderRequest = new OrderRequest();
            orderRequest.order = order;
            orderRequest.products = orderProductMapper.findOrderProduct(order.getOrderID());
            orderRequest.frames = orderFrameMapper.findOrderFrame(order.getOrderID());
            orderRequests.add(orderRequest);
        }
        return orderRequests;
    }

    public List<Order> orderList(String state,Integer page,Integer size){
        if (state.equals("0")) return orderMapper.orderList(page*size,size);
        else return orderMapper.stateFilter(state,page*size,size);
    }

    public void updateOrder(Order o){
        orderMapper.updateOrder(o);
    }

    // 待办预警
    public OrderPending orderPending(){
        OrderPending orderPending = new OrderPending();
        orderPending.toBeReviewed = orderMapper.stateOrderNum("2");
        orderPending.toBeProduced = orderMapper.stateOrderNum("3");
        orderPending.toBeDelivered = orderMapper.stateOrderNum("4");
        orderPending.refundApplication = orderMapper.stateOrderNum("9");
        orderPending.returnApplication = orderMapper.stateOrderNum("11");
        return orderPending;
    }

    public List<Order> findByDate(Date orderTime){
        return orderMapper.findByDate(orderTime);
    }

    //今日交易看板
    public TransactionBoard transactionBoard(){
        TransactionBoard transactionBoard = new TransactionBoard();
        List<Order> today = orderMapper.todayOrder();
        List<Order> yesterday = orderMapper.yesterdayOrder();
        transactionBoard.paymentOrderNum = today.size();
        transactionBoard.yesterdayOrderNum = yesterday.size();
        for (Order order:today){
            transactionBoard.paymentOrderAmount = transactionBoard.paymentOrderAmount + order.getActualPayment();
        }
        for (Order order:yesterday){
            transactionBoard.yesterdayOrderAmount = transactionBoard.yesterdayOrderAmount + order.getActualPayment();
        }
        return transactionBoard;
    }

    //订单统计
    public List<OrderStatistics> orderStatistics(){
        List<OrderStatistics> list = new ArrayList<>();

        Date today = new Date(); //获取今天的日期
        Calendar c = Calendar.getInstance();
        c.setTime(today);

        Integer i =1;

        for (i=0;i<8;i++){

            OrderStatistics o = new OrderStatistics();
            o.orderDate = c.getTime();
            List<Order> orders = orderMapper.findByDate(o.orderDate); //求当天全部订单
            o.orderNum = orders.size();
            List<Order> paymentOrders = orderMapper.findByPaymentDate(o.orderDate);//求当天全部付款订单
            o.paymentOrderNum = paymentOrders.size();

            if (o.orderNum!=0){
                o.paymentRate = o.paymentOrderNum.doubleValue()/o.orderNum;
            }

            for (Order order:paymentOrders){
                o.paymentOrderAmount = o.paymentOrderAmount + order.getActualPayment();
            }

            list.add(o);

            c.add(Calendar.DAY_OF_MONTH, -1);//求前一天
        }


        return list;
    }
}
