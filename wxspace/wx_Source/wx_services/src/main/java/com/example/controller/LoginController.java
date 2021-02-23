package com.example.controller;


import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, String> login(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        System.out.println(userId + "==" + password);
        Map<String, String> map = userService.login(userId, password);
//        System.out.println(map);
        return map;
    }


}
