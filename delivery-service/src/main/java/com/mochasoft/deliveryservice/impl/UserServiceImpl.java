package com.mochasoft.deliveryservice.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mochasoft.deliverydao.mapper.UserMapper;
import com.mochasoft.deliverydomain.User;
import com.mochasoft.deliveryservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KIKOFranklin
 * @create 2021/3/1 0001 15:38
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findSingleUser(final User user) {
        return userMapper.selectById(user.getId());
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateById(user);
    }

    @Override
    public List<User> findByPage() {
        Page<User> page = new Page<>(1,2);
        return userMapper.selectPage(page, null).getRecords();
    }
}
