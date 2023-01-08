package com.qimu.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.qimu.mybatisplus.emums.SexEnum;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField("sex")
    private SexEnum sexEnum;
}
