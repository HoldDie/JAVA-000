package com.holddie.geektime.mall;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class OrderService extends ServiceImpl<OrderMapperMaster, Order> implements IOrderService {

    @Autowired
    private OrderMapperMaster orderMapperMaster;

    @Override
    public List<Order> getMasterOrder() {
        System.out.println("查询主库");
        return orderMapperMaster.selectAll(new Order());
    }

    public void createOrder(Order order) {
        orderMapperMaster.insertSelective(order);
    }

    @Override
    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public void addSameOrders() {
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setId(543800 + i);
            order.setUserId(8 + i);
            order.setStatus("INSERT_TEST");
            orderMapperMaster.insertSelective(order);
        }
    }
}