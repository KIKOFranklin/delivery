package com.mochasoft.deliveryservice;

import com.mochasoft.deliverydomain.User;

import java.util.List;

/**
 * @author KIKOFranklin
 * @create 2021/3/1 0001 17:50
 */
public interface UserService {

    User findSingleUser(User user);

    void insert(User user);

    void update(User user);

    List<User> findByPage();

}
