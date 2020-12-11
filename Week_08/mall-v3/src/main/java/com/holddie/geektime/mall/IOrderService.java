package com.holddie.geektime.mall;


import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IOrderService extends IService<Order> {

    List<Order> getMasterOrder();

}