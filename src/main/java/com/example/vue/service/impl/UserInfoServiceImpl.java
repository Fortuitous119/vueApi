package com.example.vue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vue.service.UserInfoService;
import com.example.vue.vo.UserInfoVo;

/**
 * @author aa
 * @create 2019-02-20 16:55
 */
@Service(value = "UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public List<UserInfoVo> getUserInfoVo(String userId) {
		return userInfoMapper.selectByPrimaryKey(key);
	}
}