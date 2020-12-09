package com.holddie.geektime.mall.aop;

import com.holddie.geektime.mall.annotation.DS;
import com.holddie.geektime.mall.context.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)// 保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(ds)")
    public void changeDataSource(JoinPoint point, DS ds) throws Throwable {
        String dsId = ds.value();
        if (!DynamicDataSourceContextHolder.containDataSourceKey(dsId)) {
            logger.error("数据源[{}]不存在，使用默认数据源 > {}", ds.value(), point.getSignature());
        } else {
            logger.debug("Use DataSource : {} > {}", ds.value(), point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceKey(ds.value());
        }
    }

    @After("@annotation(ds)")
    public void restoreDataSource(JoinPoint point, DS ds) {
        logger.debug("Revert DataSource : {} > {}", ds.value(), point.getSignature());
        DynamicDataSourceContextHolder.clearDataSourceKey();
    }

}
