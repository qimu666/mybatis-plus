package com.qimu.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.qimu.mybatisplus.mapper.UserMapper;
import com.qimu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectWrapper() {
        // 查询用户名包含a,年龄在20到30之间，并且邮箱不为空的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test02() {
        // 查询用户信息，按照年龄的降序排序,若年龄相同则按id的升序排列
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test03() {
        // 删除邮箱为空的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int delete = userMapper.delete(queryWrapper);
        System.out.println(delete);
    }

    @Test
    public void test04() {
        // 将年龄大于20并且用户名中包含有a,或者邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20)
                .like("name", "a")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("柒木");
        user.setEmail("2483482026@qq.com");
        int update = userMapper.update(user, queryWrapper);
        System.out.println(update > 0 ? "修改成功" : "修改失败");
    }

    @Test
    public void test05() {
        // 用户名中包含有a,并且( 将年龄大于20或者邮箱为null )的用户信息修改
        // lambda表达式中的条件优先执行
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        User user = new User();
        user.setName("柒木木");
        user.setEmail("2483482026@qq.com");
        int update = userMapper.update(user, queryWrapper);
        System.out.println(update > 0 ? "修改成功" : "修改失败");
    }

    @Test
    public void test06() {
        // 查询用户的姓名、年龄、邮箱
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age", "email");
        List<Map<String, Object>> users = userMapper.selectMaps(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test07() {
        // 查询id小于等于100的用户信息（子查询)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id", "select id from t_user where id <=100 ");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test08() {
        // 用户名中包含有a,并且( 将年龄大于20或者邮箱为null )的用户信息修改
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        updateWrapper.set("name", "小李").set("email", "111111@qq.xom");
        int update = userMapper.update(null, updateWrapper);
        System.out.println(update > 0 ? "修改成功" : "修改失败");
    }

    @Test
    public void test09() {
        String name = "柒";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            // isNotBlank判断用户输入的字符串不是空字符串，不是null,不为空白
            queryWrapper.like("name", name);
        }
        if (ageBegin != null) {
            queryWrapper.ge("age", 20);
        }
        if (ageEnd != null) {
            queryWrapper.le("age", 30);
        }
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test10() {
        String name = "柒";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(name), "name", name)
                .ge(ageBegin != null, "age", 20)
                .le(ageEnd != null, "age", 30);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test11() {
        String name = "柒";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(name), User::getName, name)
                .ge(ageBegin != null, User::getAge, 20)
                .le(ageEnd != null,  User::getAge, 30);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
}
