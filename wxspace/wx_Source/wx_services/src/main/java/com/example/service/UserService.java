package com.example.service;

import java.util.Map;


public interface UserService {
    //登录
    public Map<String, String> login(String userId, String password);
}
