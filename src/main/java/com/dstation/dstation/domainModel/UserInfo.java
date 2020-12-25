package com.dstation.dstation.domainModel;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * UserInfo实体类
 */
@Component
public class UserInfo {
    private Long userId;
    private String userPhone;
    private String userName;
    private String userPwd;
    private Integer role;
    private Float wealth;
    private String userIcon;
    private String userSignature;
    private Date createDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Float getWealth() {
        return wealth;
    }

    public void setWealth(Float wealth) {
        this.wealth = wealth;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userPhone='" + userPhone + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", role=" + role +
                ", wealth=" + wealth +
                ", userIcon='" + userIcon + '\'' +
                ", userSignature='" + userSignature + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
