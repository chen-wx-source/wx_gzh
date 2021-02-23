package com.example.service.impl;

import com.example.entity.Menus;
import com.example.mapper.MenusMapper;
import com.example.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenusServiceImpl implements MenusService {
    @Autowired
    public MenusMapper menusMapper;

    @Override
    public List<Menus> queryMenus() {
        //查询是否存在该账号密码
        List<Menus> list;
        list = menusMapper.queryMenus();
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(list);
        //遍历

        return list;

    }
    //查询菜单

}
