package com.mybatis.dao;


import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    //若方法存在多个参数，所有的参数前面必须加上@Param注解，但引用对象不需要@Param
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id,@Param("name") String name);

    @Insert("insert into user(id,NAME,pwd) values(#{id},#{NAME},#{password})")
    int addUser(User user);

    @Update("update user set NAME = #{NAME},pwd = #{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);
}