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
}
