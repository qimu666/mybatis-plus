package com.qimu.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qimu.mybatisplus.mapper.UserMapper;
import com.qimu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusPageTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage() {
        Page<User> userPage = new Page<>(1,3);
        Page<User> selectPage = userMapper.selectPage(userPage, null);
        System.out.println(selectPage.getRecords());
    }
}
