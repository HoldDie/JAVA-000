package com.holddie.geektime.mall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class TestDsController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询全部
     */
    @GetMapping("/list")
    @ResponseBody
    public List<Order> listOrder() {
        return orderService.getMasterOrder();
    }

    @RequestMapping(path = "/create/{userId}/{orderId}", method = {RequestMethod.GET})
    public String createOrder(@PathVariable("userId") Long userId, @PathVariable("orderId") Long orderId) {
        Order order = new Order();
        order.setId(orderId);
        order.setUserId(userId);
        orderService.createOrder(order);
        return "success";
    }
}