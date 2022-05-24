package com.lhzh.mybatisstudy.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.weixin")
    public DataSource getWeixinDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.test")
    public DataSource getTestDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource getTestDataSource,DataSource getWeixinDataSource ){
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put("test",getTestDataSource);
        targetDataSource.put("weixin",getWeixinDataSource);
        return new DynamicDataSource(getTestDataSource,targetDataSource);
    }
}
