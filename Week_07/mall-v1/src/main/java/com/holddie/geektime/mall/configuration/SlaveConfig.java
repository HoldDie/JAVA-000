package com.holddie.geektime.mall.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 功能简述：
 *
 * @author qiancy
 * @create 2020/12/1
 * @since 1.0.0
 */
@Configuration
@MapperScan(basePackages = {"com.holddie.geektime.mall.mapper.slave"}, sqlSessionFactoryRef = "sqlSessionFactorySlave")
public class SlaveConfig {
    @Autowired
    @Qualifier(DataSourceConstants.DS_KEY_SLAVE)
    private DataSource dataSourceSlave;


    @Bean
    public SqlSessionFactory sqlSessionFactorySlave() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceSlave);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/slave/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateSlave() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactorySlave());
    }

}
