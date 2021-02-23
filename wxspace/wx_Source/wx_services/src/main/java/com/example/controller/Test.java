package com.example.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Test {
    @Autowired
    private UserService userService;

    @RequestMapping("/logintest")
    @ResponseBody
    public Map<String, String> login(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        System.out.println(userId + "==" + password);
        Map<String, String> map = userService.login(userId, password);
//        System.out.println(map);
        return map;
    }

    @RequestMapping("/queryMenustest")
    @ResponseBody
    public List<JSONObject> queryMenus() {
        Map<String, String> map = new HashMap<String, String>();
        String jsonStr = "{\"id\":\"101\",\"menuName\":\"用户管理\",\"icon\":\"el-icon-user-solid\",\"path\":\"\", \"children\":[ {\"id\":\"1011\",\"menuName\":\"用户列表\",\"icon\":\"el-icon-menu\",\"path\":\"/UserMsg\"} ] }";
        JSONObject json = JSONObject.parseObject(jsonStr);
        List<JSONObject> list = new ArrayList<JSONObject>();
        list.add(json);

        return list;
    }

    //        Enumeration em = request.getParameterNames();
//        System.out.println("--"+em.hasMoreElements());
//        while (em.hasMoreElements()) {
//            String name = (String) em.nextElement();
//            String value = request.getParameter(name);
//        }
//        System.out.println(request.getParameter("userName"));
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("rtnCode","1");
//        map.put("rtnMsg","登陆成功");
    @RequestMapping("/queryDemotest")
    @ResponseBody
    public List<JSONObject> queryDemo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "测试");
        map.put("2", "测试");
        System.out.println(map);
        List<JSONObject> list = new ArrayList<JSONObject>();
        String s = "{\"id\":\"111\"}";
        JSONObject json = JSONObject.parseObject(s);
        list.add(json);
        return list;
    }

    public static void main(String[] args) {
//        System.out.println(1);
        InputStream inputStream = null;
        byte[] data = null;

    }
}
