package com.holddie.rpc;

import com.holddie.rpc.api.User;
import com.holddie.rpc.api.UserService;
public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "KK" + System.currentTimeMillis());
    }
}
