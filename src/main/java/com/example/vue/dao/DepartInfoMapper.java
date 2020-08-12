package com.example.vue.dao;

import java.util.List;

import com.example.vue.entity.DepartInfo;

public interface DepartInfoMapper {
    int deleteByPrimaryKey(Integer departmentid);

    int insert(DepartInfo record);

    int insertSelective(DepartInfo record);

    List<DepartInfo> selectByPrimaryKey();

    int updateByPrimaryKeySelective(DepartInfo record);

    int updateByPrimaryKey(DepartInfo record);
}