package com.holddie.geektime.mall.mapper.master;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.holddie.geektime.mall.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapperMaster extends BaseMapper<Order> {

    @Override
    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectAll(Order order);
}