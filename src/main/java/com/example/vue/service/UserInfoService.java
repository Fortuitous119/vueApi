package com.example.vue.service;

import java.util.List;

import com.example.vue.vo.UserInfoVo;
/**
 * @author aa
 * @create 2019-02-20 16:55
 */
public interface UserInfoService {

	List<UserInfoVo> getUserInfoVo(String userId);

}


