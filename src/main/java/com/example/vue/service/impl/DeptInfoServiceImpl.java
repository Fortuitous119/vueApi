package com.example.vue.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vue.dao.DepartInfoMapper;
import com.example.vue.entity.DepartInfo;
import com.example.vue.service.DeptInfoService;
import com.example.vue.vo.DeptInfoVo;

/**
 * @author aa
 * @create 2019-02-20 16:55
 */
@Service(value = "DeptInfoService")
public class DeptInfoServiceImpl implements DeptInfoService {

	@Autowired
	private DepartInfoMapper departInfoMapper;
	
	@Override
	public List<DeptInfoVo> getDeptLst() throws SQLException{
		List<DeptInfoVo> lstDeptInfoVo = new ArrayList<DeptInfoVo>();
		
		List<DepartInfo> lstDeptInfo= departInfoMapper.selectByPrimaryKey();
		
		for(DepartInfo departInfo : lstDeptInfo){
			DeptInfoVo deptInfoVo = new DeptInfoVo();
			deptInfoVo.setDiaDepartmentId(departInfo.getDepartmentid());
			deptInfoVo.setDiaDepartmentName(departInfo.getDepartmentname());
			lstDeptInfoVo.add(deptInfoVo);
		}
		
		return lstDeptInfoVo;
	}
}