package com.example.vue.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vue.dao.UserInfoMapper;
import com.example.vue.entity.UserInfo;
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
	public List<UserInfoVo> getUserInfoVo(String employeeid) throws SQLException{
		List<UserInfoVo> lstUserInfoVo = new ArrayList<UserInfoVo>();
		
		List<UserInfo> lstuserInfo= userInfoMapper.selectByPrimaryKey(employeeid);
		
		for(UserInfo userInfo : lstuserInfo){
			UserInfoVo userInfoVo = new UserInfoVo();
			BeanUtils.copyProperties(userInfo, userInfoVo);
			lstUserInfoVo.add(userInfoVo);
		}
		
		return lstUserInfoVo;
	}
	
	@Override
	public Integer del(String employeeid) throws SQLException{
		return userInfoMapper.deleteByPrimaryKey(employeeid);
	}
	
	@Override
	public Integer ins(UserInfoVo userInfo) throws SQLException{
		UserInfo record = new UserInfo();
		
		BeanUtils.copyProperties(userInfo, record);
		return userInfoMapper.insertSelective(record);
	}
}