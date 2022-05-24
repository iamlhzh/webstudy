package com.lhzh.mybatisstudy.service;

import com.lhzh.mybatisstudy.config.DynamicDataSource;
import com.lhzh.mybatisstudy.dao.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloMapper helloMapper;

    public String getTest(String id){
        String str = helloMapper.getTest(id);
        return str;
    }

    public String getWeixin(String id) {
        DynamicDataSource.setDataSource("weixin");
        String str = helloMapper.getWeixin(id);
        DynamicDataSource.clearDataSource();
        return str;
    }
}
