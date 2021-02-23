package com.example.mapper;

import com.example.entity.Menus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenusMapper {
    int insert(Menus record);

    int insertSelective(Menus record);

    //查询菜单
    public List<Menus> queryMenus();
}