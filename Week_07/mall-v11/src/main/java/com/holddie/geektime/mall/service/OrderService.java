package com.holddie.geektime.mall.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.holddie.geektime.mall.annotation.DS;
import com.holddie.geektime.mall.configuration.DataSourceConstants;
import com.holddie.geektime.mall.entity.Order;
import com.holddie.geektime.mall.mapper.OrderMapperMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService extends ServiceImpl<OrderMapperMaster, Order> implements IOrderService {

    @Autowired
    private OrderMapperMaster master;

    @Override
    public List<Order> getMasterOrder() {
        System.out.println("查询主库");
        return master.selectAll(new Order());
    }

    @Override
    @DS(value = DataSourceConstants.DS_KEY_SLAVE)
    public List<Order> getSlaveUser() {
        System.out.println("查询从库");
        return master.selectAll(null);
    }
}