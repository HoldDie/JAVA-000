package com.holddie.geektime.mall.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "t_order")
public class Order {
    private String id;

    private String userId;

    private String amount;

    private String status;

    private Date createTime;

    private Date updateTime;
}