package com.example.vue.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	 * 根据部门取得画面显示内容
	 * @param String 登录者ID，审批编号
	 * @return BaseResponse
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getUserInfo", produces = {"application/json;charset=UTF-8"})
	public BaseResponse <List<UserInfoVo>> getUserInfo(@RequestParam("userId") String userId)
			throws ParseException{
		List<UserInfoVo> userInfo = new ArrayList<UserInfoVo>();

		try {	
			// 查询显示内容
			userInfo = userInfoService.getUserInfoVo(userId);
		}catch(Exception e) {
			return ResponseUtil.error(2, e.getMessage());
		}
		return ResponseUtil.success(userInfo);
	}
}