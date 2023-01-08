package com.qimu.mybatisplus;

import com.qimu.mybatisplus.service.ProductService;
import com.qimu.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataSouseTest {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Test
    public void test(){
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
    }
}
