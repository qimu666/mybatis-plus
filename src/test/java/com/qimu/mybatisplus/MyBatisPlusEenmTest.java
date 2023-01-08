package com.qimu.mybatisplus;

import com.qimu.mybatisplus.emums.SexEnum;
import com.qimu.mybatisplus.mapper.UserMapper;
import com.qimu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusEenmTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        User user = new User();
        user.setAge(18);
        user.setName("张三");
        user.setSexEnum(SexEnum.MALE);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
}
