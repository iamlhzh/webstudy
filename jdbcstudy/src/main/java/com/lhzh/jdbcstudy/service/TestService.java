package com.lhzh.jdbcstudy.service;


import com.lhzh.jdbcstudy.config.DynamicDataSource;
import com.lhzh.jdbcstudy.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public String getTest(String id){
        String str = testMapper.getTest(id);
        return str;
    }

    public String getWeixin(String id) {
        DynamicDataSource.setDataSource("weixin");
        String str = testMapper.getWeixin(id);
        DynamicDataSource.clearDataSource();
        return str;
    }
}
