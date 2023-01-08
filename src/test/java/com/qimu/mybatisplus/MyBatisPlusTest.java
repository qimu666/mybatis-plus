package com.qimu.mybatisplus;

import com.qimu.mybatisplus.mapper.UserMapper;
import com.qimu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectList(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setAge(18);
        user.setEmail("2483482026@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("result"+insert);
        System.out.println("id"+user.getId());
    }
    @Test
    public void testDelete(){

    }
}
