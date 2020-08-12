package com.example.vue.service;

import java.sql.SQLException;
import java.util.List;

import com.example.vue.vo.DeptInfoVo;
/**
 * @author aa
 * @create 2019-02-20 16:55
 */
public interface DeptInfoService {

	List<DeptInfoVo> getDeptLst() throws SQLException;

}


