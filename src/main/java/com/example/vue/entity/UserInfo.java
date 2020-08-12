package com.example.vue.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户信息表
 */
@Data
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 员工ID
     */
    private String employeeId;

    /**
     * 中文名
     */
    private String name;

    /**
     * 登录手机号
     */
    private String phone;

    /**
     * 所属部门
     */
    private String departmentId;
    private String departmentName;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 英文名
     */
    private String englishName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 职务
     */
    private String duty;

    /**
     * 秘书
     */
    private String secretary;

    /**
     * 座机
     */
    private String officeTel;

    /**
     * 办公地址
     */
    private String address;

    /**
     * 备注
     */
    private String memo;
}