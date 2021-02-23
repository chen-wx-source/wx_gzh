package com.example.controller;

import com.example.entity.Menus;
import com.example.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenusController {
    @Autowired
    private MenusService menusService;

    @RequestMapping("/queryMenus")
    @ResponseBody
    public List<Menus> queryMenus() {
        Map<String, String> map = new HashMap<String, String>();
//        String jsonStr="{\"id\":\"101\",\"menuName\":\"用户管理\",\"icon\":\"el-icon-user-solid\",\"path\":\"\", \"children\":[ {\"id\":\"1011\",\"menuName\":\"用户列表\",\"icon\":\"el-icon-menu\",\"path\":\"/UserMsg\"} ] }";
//        JSONObject json=JSONObject.parseObject(jsonStr);
//        List<JSONObject> list=  new ArrayList<JSONObject>();
//        list.add(json);
        List<Menus> menuList;
        menuList = menusService.queryMenus();

        return menuList;
    }


}
