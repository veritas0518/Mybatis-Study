package com.mybatis.dao;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //根据id查询用户
    User getUserById(@Param("qid") int id);

    //分页
    List<User> getUserByLimit(Map<String,Object> map);
}