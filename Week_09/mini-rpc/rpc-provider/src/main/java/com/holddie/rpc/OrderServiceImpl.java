package com.holddie.rpc;


import com.holddie.rpc.api.Order;
import com.holddie.rpc.api.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "Cuijing" + System.currentTimeMillis(), 9.9f);
    }
}
