package com.holddie.geektime.mall.controller;

import com.holddie.geektime.mall.entity.Order;
import com.holddie.geektime.mall.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能简述：
 *
 * @author qiancy
 * @create 2020/12/2
 * @since 1.0.0
 */
@RestController
public class TestController {

    @Autowired
    IOrderService orderService;

    @RequestMapping(path = "/createOrder/{userId}/{orderId}", method = {RequestMethod.GET})
    public String createOrder(@PathVariable("userId") String userId, @PathVariable("orderId") String orderId) {
        Order order = new Order();
        order.setId(orderId);
        order.setUserId(userId);
        orderService.createOrder(order);
        return "success";
    }

    @RequestMapping(path = "/{userId}", method = {RequestMethod.GET})
    public List<Order> getOrderListByUserId(@PathVariable("userId") Integer userId) {
        return orderService.getOrderListByUserId(userId);
    }

    @RequestMapping(path = "/", method = {RequestMethod.GET})
    public List<Order> getOrderListByUserId() {
        return orderService.getOrderList();
    }

}
