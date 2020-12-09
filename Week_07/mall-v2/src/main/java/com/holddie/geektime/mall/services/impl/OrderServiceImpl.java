package com.holddie.geektime.mall.services.impl;

import com.holddie.geektime.mall.entity.Order;
import com.holddie.geektime.mall.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能简述：
 *
 * @author qiancy
 * @create 2020/12/2
 * @since 1.0.0
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Order> getOrderListByUserId(Integer userId) {
        return null;
    }

    @Override
    public List<Order> getOrderList() {
        String sql = "select * from t_order ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(
                Order.class));
    }

    @Override
    public void createOrder(Order order) {
        StringBuffer sb = new StringBuffer();
        sb.append("insert into t_order(id, user_id)");
        sb.append("values(");
        sb.append("'" + order.getUserId()).append("',");
        sb.append("'" + order.getId());
        sb.append("')");
        jdbcTemplate.update(sb.toString());
    }
}
