package com.lhzh.mybatisstudy.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HelloMapper {

    String getTest(String id);

    String getWeixin(String id);
}
