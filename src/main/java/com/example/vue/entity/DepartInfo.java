package com.example.vue.entity;

import java.io.Serializable;

/**
 * 
 */
public class DepartInfo implements Serializable {
    /**
     * 部门ID
     */
    private Integer departmentid;

    /**
     * 部门名称
     */
    private String departmentname;

    private static final long serialVersionUID = 1L;

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", departmentid=").append(departmentid);
        sb.append(", departmentname=").append(departmentname);
        sb.append("]");
        return sb.toString();
    }
}