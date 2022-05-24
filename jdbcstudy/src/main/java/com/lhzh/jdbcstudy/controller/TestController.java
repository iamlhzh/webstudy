package com.lhzh.jdbcstudy.controller;

import com.lhzh.jdbcstudy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("getTest")
    public String getTest(String id){
        String str = testService.getTest(id);
        return str;
    }

    @RequestMapping("getWeixin")
    public String getWeixin(String id){
        String str = testService.getWeixin(id);
        return str;
    }
}
