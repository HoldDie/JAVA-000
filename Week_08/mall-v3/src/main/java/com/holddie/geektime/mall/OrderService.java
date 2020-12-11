package com.holddie.geektime.mall;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService extends ServiceImpl<OrderMapperMaster, Order> implements IOrderService {

    @Autowired
    private OrderMapperMaster orderMapperMaster;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Order> getMasterOrder() {
        System.out.println("查询主库");
        return orderMapperMaster.selectAll(new Order());
    }

    public void createOrder(Order order) {
        StringBuffer sb = new StringBuffer();
        sb.append("insert into t_order(id, user_id)");
        sb.append("values(");
        sb.append(order.getId());
        sb.append(",");
        sb.append(order.getUserId());
        sb.append(")");
        jdbcTemplate.update(sb.toString());
    }
}