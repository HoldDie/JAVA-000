package com.holddie.geektime.mall.service;

import com.holddie.geektime.mall.entity.Order;
import com.holddie.geektime.mall.mapper.master.OrderMapperMaster;
import com.holddie.geektime.mall.mapper.slave.OrderMapperSlave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapperMaster master;

    @Autowired
    private OrderMapperSlave slave;

    public List<Order> getMasterOrder() {
        System.out.println("查询主库");

        return master.selectAll(new Order());
    }

    public List<Order> getSlaveUser() {
        System.out.println("查询从库");
        return slave.selectAll(null);
    }
}