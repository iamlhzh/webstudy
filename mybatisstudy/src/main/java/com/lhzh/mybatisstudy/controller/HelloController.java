package com.lhzh.mybatisstudy.controller;

import com.lhzh.mybatisstudy.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("getTest")
    public String getTest(String id){
        String str = helloService.getTest(id);
        return str;
    }

    @RequestMapping("getWeixin")
    public String getWeixin(String id){
        String str = helloService.getWeixin(id);
        return str;
    }
}
