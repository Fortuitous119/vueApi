package com.example.vue.entity;

import java.io.Serializable;

/**
 * 用户信息表
 */
public class UserInfo implements Serializable {
    /**
     * 员工ID
     */
    private String employeeId;

    /**
     * 中文名
     */
    private String name;

    /**
     * 登录手机号
     */
    private String phone;

    /**
     * 所属部门
     */
    private String department;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 英文名
     */
    private String englishName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 职务
     */
    private String duty;

    /**
     * 秘书
     */
    private String secretary;

    /**
     * 座机
     */
    private String officeTel;

    /**
     * 办公地址
     */
    private String address;

    /**
     * 备注
     */
    private String memo;

    private static final long serialVersionUID = 1L;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getSecretary() {
        return secretary;
    }

    public void setSecretary(String secretary) {
        this.secretary = secretary == null ? null : secretary.trim();
    }

    public String getOfficeTel() {
        return officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel == null ? null : officeTel.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeId=").append(employeeId);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", department=").append(department);
        sb.append(", sex=").append(sex);
        sb.append(", englishName=").append(englishName);
        sb.append(", email=").append(email);
        sb.append(", duty=").append(duty);
        sb.append(", secretary=").append(secretary);
        sb.append(", officeTel=").append(officeTel);
        sb.append(", address=").append(address);
        sb.append(", memo=").append(memo);
        sb.append("]");
        return sb.toString();
    }
}