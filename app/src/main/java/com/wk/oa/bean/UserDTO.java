package com.wk.oa.bean;

import java.io.Serializable;

/**
 * 用户dto为了作显示用
 *
 * @author zxy
 */
@SuppressWarnings("serial")
public class UserDTO implements Serializable {

    public static final String JSON_TAG_ID = "id";
    public static final String JSON_TAG_ACCOUNT = "account";
    public static final String JSON_TAG_PASSWORD = "password";
    public static final String JSON_TAG_USERNAME = "userName";
    public static final String JSON_TAG_STATUS = "status";
    public static final String JSON_TAG_BUSINESS = "business";
    public static final String JSON_TAG_DEPTID = "deptId";
    public static final String JSON_TAG_USERTYPE = "userType";
    public static final String JSON_TAG_LOGINTIME = "loginTime";
    public static final String JSON_TAG_LASTLOGINTIME = "lastLoginTime";
    public static final String JSON_TAG_LOSECOUNT = "loseCount";
    public static final String JSON_TAG_DEPTNAME = "deptName";
    public static final String JSON_TAG_PARENTID = "parentId";
    public static final String JSON_TAG_NAME = "name";
    public static final String JSON_TAG_ORGTREE = "orgTree";
    public static final String JSON_TAG_ORG = "org";
    public static final String JSON_TAG_TOKEN = "token";

    @Override
    public String toString() {
        return "UserDTO{" +
                "status='" + status + '\'' +
                ", userId='" + userId + '\'' +
                ", realName='" + realName + '\'' +
                ", roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", business='" + business + '\'' +
                ", password='" + password + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", Id='" + Id + '\'' +
                ", org='" + org + '\'' +
                ", token='" + token + '\'' +
                ", accid='" + accid + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    /**
     * 状态
     */
    private String status;
    /**
     * 用户名
     */
    private String userId;
    /**
     * 姓名
     */
    private String realName;

    private String roleId;
    private String roleName;
    private String departmentId;
    private String departmentName;
    /**
     * 职务
     */
    private String business;
    /**
     * 密码
     */
    private String password;
    private String sessionId;
    /**
     * 用户ID
     */
    private String Id;
    private String org;
    /**
     * 网易云token
     */
    private String token;

    private String accid;


//    /**
//     * 用户ID
//     */
//    private String id;
//    /**
//     * 用户
//     */
//    private String userId;
//
//    /**
//     * 密码
//     */
//    private String password;
//
//    /**
//     * 用户名
//     */
//    private String userName;
//    /**
//     * 职务
//     */
//    private String business;
//
//    /**
//     * department id
//     */
//    private String deptId;
//
//    /**
//     * 用户类型 0 为超级管理员 1 为其它用户
//     */
//    private String userType;
//
//    /**
//     * 登录时间
//     */
//    private String loginTime;
//
//    /**
//     * 最后一次登录时间
//     */
//    private String lastLoginTime;
//
//    /**
//     * 状态 0:删除 1:正常 2:锁定
//     */
//    private String status;
//
//    /**
//     * 30分钟登陆错误次数
//     */
//    private String loseCount;
//
//    private String deptName;
//
//    private String parentId;
//
//    private String name;
//    /**
//     * 部门结构（上上级部门id-上级部门id)
//     */
//    private String orgTree;
//
//    private String org;
//
//    /**
//     * 网易云token
//     */
//    private String token;
}