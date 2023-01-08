package com.qimu.mybatisplus.service.impl;

import com.qimu.mybatisplus.mapper.ProductMapper;
import com.qimu.mybatisplus.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void test01() {
        // 小王查询的价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询的价格" + productWang.getPrice());

        // 小李查询的价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询的价格" + productLi.getPrice());

        // 小王修改价格+50
        productWang.setPrice(productWang.getPrice() + 50);
        productMapper.updateById(productWang);

        // 小李修改价格-30
        productLi.setPrice(productLi.getPrice() - 30);
        int result = productMapper.updateById(productLi);
        if (result == 0) {
            // 操作失败重试
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice() - 30);
            productMapper.updateById(productNew);
        }

        //老板查询的价格
        Product productBoos = productMapper.selectById(1);
        System.out.println("老板查询的价格" + productBoos.getPrice());
    }
}