package com.dstation.dstation.service.interf;

import com.alibaba.fastjson.JSONObject;
import com.dstation.dstation.domainModel.UserInfo;

public interface IUserInfoService {

    public boolean findUserPhoneIsExist(String userPhone);

    public boolean addUserInfo(UserInfo userInfo);

    public UserInfo findUserInfo(UserInfo userInfo);
}
