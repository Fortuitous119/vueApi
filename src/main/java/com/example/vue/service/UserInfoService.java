package com.example.vue.service;

import java.sql.SQLException;
import java.util.List;

import com.example.vue.vo.UserInfoVo;
/**
 * @author aa
 * @create 2019-02-20 16:55
 */
public interface UserInfoService {

	List<UserInfoVo> getUserInfoVo(String employeeId) throws SQLException;
	
	Integer del(String employeeId) throws SQLException;
	
	Integer ins(UserInfoVo userInfo) throws SQLException;

}


