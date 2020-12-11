package com.holddie.geektime.mall;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "t_order")
public class Order {
    private long id;

    private long userId;

    private String amount;

    private String status;

    private Date createTime;

    private Date updateTime;
}