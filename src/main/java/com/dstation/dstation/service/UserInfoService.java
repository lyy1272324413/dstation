package com.dstation.dstation.service;

import com.alibaba.fastjson.JSONObject;
import com.dstation.dstation.dao.UserInfoDao;
import com.dstation.dstation.domainModel.UserInfo;
import com.dstation.dstation.service.interf.IUserInfoService;
import com.dstation.dstation.util.Constant;
import com.dstation.dstation.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class UserInfoService implements IUserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public boolean findUserPhoneIsExist(String userPhone) {
        String queryUserPhone = userInfoDao.findUserPhoneByUserPhone(userPhone);
        if(queryUserPhone == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean addUserInfo(UserInfo userInfo) {
        //1. 设置一些用户的默认信息
        userInfo.setRole(Constant.USER_ROLE);
        userInfo.setWealth(Constant.USER_WEALTH);
        userInfo.setUserIcon(Constant.USER_DEFAULT_ICON);
        userInfo.setUserSignature(Constant.USER_SIGNATURE);
        //2. 对用户密码进行MD5加密
        try {
            userInfo.setUserPwd(MD5.encryption(userInfo.getUserPwd(), Constant.KEY));   //对用户密码进行加密
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //3. 保存用户
        int addResult = userInfoDao.insertUserInfo(userInfo);
        if(addResult != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserInfo findUserInfo(UserInfo userInfo) {
        try {
            userInfo.setUserPwd(MD5.encryption(userInfo.getUserPwd(), Constant.KEY));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return userInfoDao.selectUserInfo(userInfo);
    }
}
