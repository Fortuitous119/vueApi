package com.example.vue.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vue.response.BaseResponse;
import com.example.vue.service.UserInfoService;
import com.example.vue.utils.ResponseUtil;
import com.example.vue.vo.UserInfoVo;

/**
 * 用户信息检索
 * @author chen
 * @create 2019-03-06 10:44
 */
@RestController
@RequestMapping(value = "/userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	/**
	 * 查询信息
	 * @param String employeeId 员工ID
	 * @return BaseResponse
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getUserInfo")
	public BaseResponse <List<UserInfoVo>> getUserInfo(@RequestParam("employeeId") String employeeId)
			throws ParseException{
		List<UserInfoVo> userInfo = new ArrayList<UserInfoVo>();

		try {	
			// 查询显示内容
			userInfo = userInfoService.getUserInfoVo(employeeId);
		}catch(Exception e) {
			return ResponseUtil.error(2, e.getMessage());
		}
		return ResponseUtil.success(userInfo);
	}
	
	/**
	 * 删除信息
	 * @param String employeeId 员工ID
	 * @return BaseResponse
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/del")
	public BaseResponse<Integer> del(@RequestParam("employeeId") String employeeId)
			throws ParseException{
		Integer result = 0;
		try {
			result = userInfoService.del(employeeId);
		} catch (SQLException e) {
			return ResponseUtil.error(2, e.getMessage());
		}
		return ResponseUtil.success(result);
	}
	
	/**
	 * 插入信息
	 * @param params
	 * @return
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/ins", produces = {"application/json;charset=UTF-8"})
	public BaseResponse<Integer> insFinishQuantitiesList(@RequestBody UserInfoVo params)
			throws ParseException{

		Integer result = 0;
		try {
			result = userInfoService.ins(params);
		} catch (SQLException e) {
			return ResponseUtil.error(2, e.getMessage());
		}
		return ResponseUtil.success(result);
	}
}