package com.lhzh.jdbcstudy.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    String getTest(String id);

    String getWeixin(String id);
}
