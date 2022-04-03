package com.mybatis.dao;

import com.mybatis.pojo.User;
import com.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserDaoTest
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/10/10 18:51
 **/

public class UserMapperTest {

    @Test
    public void getUserLike() {
        //第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper来获得当前绑定的接口（推荐）
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getUserLike("李");

        list.forEach(System.out::println);
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void test() {

        //第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper来获得当前绑定的接口（推荐）
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        userList.forEach(System.out::println);

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void getUserById2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("helloid", 1);

        mapper.addUser2(map);
        sqlSession.close();
    }

    //增删改需要提交事务!!!!!!!!!!!!!!
    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int user = mapper.addUser(new User(4, "小学", "111234"));
        if (user > 0) {

            System.out.println("插入成功，有" + user + "条数据");
        } else {
            System.out.println("插入失败");
        }

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void addUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("userid", 5);
        map.put("username", "hello");
        map.put("password", "2222333");
        mapper.addUser2(map);
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int user = mapper.updateUser(new User(1, "小薛", "2000518"));
        if (user > 0) {
            System.out.println("更改成功" + user + "条记录");
        } else {
            System.out.println("更改失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int deleteUser = mapper.deleteUser(4);
        if (deleteUser > 0) {
            System.out.println("删除成功" + deleteUser + "条");
        } else {
            System.out.println("删除失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

}
