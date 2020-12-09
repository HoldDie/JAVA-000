package com.holddie.geektime.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.holddie.geektime.mall.annotation.DS;
import com.holddie.geektime.mall.configuration.DataSourceConstants;
import com.holddie.geektime.mall.entity.Order;

import java.util.List;

public interface IOrderService extends IService<Order> {

    @DS(value = DataSourceConstants.DS_KEY_MASTER)
    List<Order> getMasterOrder();

    @DS(value = DataSourceConstants.DS_KEY_SLAVE)
    List<Order> getSlaveUser();
}