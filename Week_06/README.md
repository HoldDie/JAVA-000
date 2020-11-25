学习笔记

基础订单表

会员表

```sql
CREATE TABLE `member_info` (
  `id` bigint NOT NULL,
  `user_code` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '用户编码-全局唯一标识',
  `user_nick_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '用户昵称',
  `phone` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '联系方式',
  `acitvity` tinyint NOT NULL DEFAULT '1' COMMENT '是否激活',
  `deleted` tinyint DEFAULT '0' COMMENT '是否删除',
  `add_time` bigint NOT NULL DEFAULT '0' COMMENT '会员添加时间',
  `last_login_time` bigint DEFAULT '0' COMMENT '最后登陆时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
```

用户表
```sql
CREATE TABLE `user_info` (
  `id` bigint NOT NULL,
  `member_info_id` bigint NOT NULL COMMENT '会员ID',
  `validate_type` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '验证类型：账号密码、邮箱、微信、支付宝',
  `validate_info` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '验证信息',
  `validate_pwd` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '验证密码',
  `deleted` tinyint DEFAULT '0' COMMENT '是否删除',
  `activity` tinyint DEFAULT '1' COMMENT '是否激活',
  `bind_time` bigint DEFAULT '0' COMMENT '绑定时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
```

订单表
```sql
CREATE TABLE `order_info` (
  `id` int NOT NULL,
  `order_no` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '订单唯一编码',
  `child_order` tinyint NOT NULL COMMENT '是否是子订单',
  `paraent_order_no` varchar(128) COLLATE utf8_bin DEFAULT '0000' COMMENT '父订单编码',
  `member_info_id` bigint NOT NULL COMMENT '会员信息',
  `money` decimal(20,5) NOT NULL COMMENT '订单有效金额',
  `state` varchar(8) COLLATE utf8_bin NOT NULL COMMENT '状态：110:待付款  115: 系统校验 120:卖家待发货 130：待签收 140：签收完成 \\n200：正常完结  \\n400：异常完结',
  `addtime` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
```

订单明细表
```sql

CREATE TABLE `order_detail` (
  `id` bigint NOT NULL,
  `order_info_id` bigint NOT NULL COMMENT '订单ID',
  `product_id` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '商品Id',
  `product_name` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(20,5) NOT NULL COMMENT '商品价格',
  `product_count` int NOT NULL COMMENT '商品数量',
  `product_discount_price` decimal(20,5) DEFAULT NULL COMMENT '商品优惠金额',
  `state` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
```
