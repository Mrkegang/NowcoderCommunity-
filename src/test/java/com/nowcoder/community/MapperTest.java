package com.nowcoder.community;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author kg
 * @version 1.0
 * @date 2022/4/28 23:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = NowcoderCommunityApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);

        System.out.println("+++++++++++++++++");
        User test = userMapper.selectByName("Test");
        System.out.println(test);

        System.out.println("+++++++++++++++++");
        User user1 = userMapper.selectByEmail("2940730274@qq.com");
        System.out.println(user1);


    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("test22");
        user.setPassword("123456");
        user.setSalt("123");
        user.setEmail("1234231523@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
    }

    @Test
    public void testUpdateUser() {
        int rows = userMapper.updatePassword(101, "123459");
        System.out.println(rows);

        rows = userMapper.updateHeader(150, "http://www.nowcoder.com/102.png");
        System.out.println(rows);

        rows = userMapper.updateStatus(150,1);
        System.out.println(rows);

    }
}