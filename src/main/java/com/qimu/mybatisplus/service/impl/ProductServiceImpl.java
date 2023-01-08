package com.qimu.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qimu.mybatisplus.mapper.ProductMapper;
import com.qimu.mybatisplus.pojo.Product;
import com.qimu.mybatisplus.service.ProductService;
import org.springframework.stereotype.Service;

@DS("datasource_2")
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
