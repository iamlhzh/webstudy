package com.lhzh.jdbcstudy.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @Value("${spring.datasource.druid.initial-size}")
    private int initialSize;

    @Value("${spring.datasource.druid.max-active}")
    private int maxActive;

    @Value("${spring.datasource.druid.min-idle}")
    private int minIdle;

    @Value("${spring.datasource.druid.max-wait}")
    private long maxWait;

    @Value("${spring.datasource.druid.validation-query}")
    private String validationQuery;

    @Value("${spring.datasource.druid.validation-query-timeout}")
    private int validationQueryTimeout;

    @Value("${spring.datasource.druid.driver-class-name}")
    private String driverClassName;

    @Bean
    @ConfigurationProperties("spring.datasource.druid.test")
    public DataSource testDataSource() {
        DruidDataSource dataSource =  DruidDataSourceBuilder.create().build();
        this.getDataSource(dataSource);
        return dataSource;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.weixin")
    public DataSource weixinDataSource() {
        DruidDataSource dataSource =  DruidDataSourceBuilder.create().build();
        this.getDataSource(dataSource);
        return dataSource;
    }


    private void getDataSource(DruidDataSource dataSource) {
        dataSource.setDriverClassName(driverClassName);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setValidationQueryTimeout(validationQueryTimeout);
    }

    @Bean
    @Primary
    public DataSource dataSource(DataSource testDataSource,DataSource weixinDataSource) {
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put("test", testDataSource);
        dsMap.put("weixin", weixinDataSource);
        DynamicDataSource dynamicDataSource = new DynamicDataSource(testDataSource,dsMap);
        return dynamicDataSource;
    }

}