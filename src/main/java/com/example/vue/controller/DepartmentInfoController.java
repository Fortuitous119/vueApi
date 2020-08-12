package com.example.vue.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vue.response.BaseResponse;
import com.example.vue.service.DeptInfoService;
import com.example.vue.utils.ResponseUtil;
import com.example.vue.vo.DeptInfoVo;

/**
 * 用户信息检索
 * @author chen
 * @create 2019-03-06 10:44
 */
@RestController
@RequestMapping(value = "/departmentInfo")
public class DepartmentInfoController {

	@Autowired
	private DeptInfoService deptInfoService;

	/**
	 * 查询部门信息
	 * @param 空
	 * @return BaseResponse
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getdepartmentLst")
	public BaseResponse <List<DeptInfoVo>> getdepartmentLst()
			throws ParseException{
		List<DeptInfoVo> deptInfo = new ArrayList<DeptInfoVo>();

		try {	
			// 查询显示内容
			deptInfo = deptInfoService.getDeptLst();
		}catch(Exception e) {
			return ResponseUtil.error(2, e.getMessage());
		}
		return ResponseUtil.success(deptInfo);
	}
}