package com.mochasoft.deliveryservice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mochasoft.deliverydao.mapper.UserMapper;
import com.mochasoft.deliverydomain.User;
import com.mochasoft.deliveryservice.UserService;
import org.springframework.stereotype.Service;

/**
 * @author KIKOFranklin
 * @create 2021/3/1 0001 15:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
