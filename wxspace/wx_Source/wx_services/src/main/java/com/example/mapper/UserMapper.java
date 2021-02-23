package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public int queryAccount(String userId,String password);


}
