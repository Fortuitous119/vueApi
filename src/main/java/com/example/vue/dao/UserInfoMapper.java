package com.example.vue.dao;

import java.util.List;

import com.example.vue.entity.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String employeeId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByPrimaryKey(String employeeId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}