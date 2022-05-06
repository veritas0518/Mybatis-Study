package com.mybatis.dao;

import com.mybatis.pojo.User;
import com.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
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

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<User> userList = mapper.getUserByLimit(map);
        userList.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void test() {

        //第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        logger.error("测试，进入getUserLike方法成功！");

        //方式一：getMapper来获得当前绑定的接口（推荐）
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.info("info:进入了testLog4j方法");
        logger.debug("debug:进入了testLog4j方法");
        logger.error("error:进入了testLog4j方法");
    }
}
