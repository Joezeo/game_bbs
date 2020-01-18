package com.joezeo.community.service;

import com.joezeo.community.pojo.User;

public interface UserService {
    void addUser(User user);

    User queryUserByToken(String token);

    User queryByAccountid(String accountId);

    void updateUser(User user);
}
