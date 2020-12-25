package com.dstation.dstation.dao;

import com.dstation.dstation.domainModel.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoDao {

    public String findUserPhoneByUserPhone(@Param("userPhone") String userPhone);

    public int insertUserInfo(@Param("userInfo") UserInfo userInfo);

    public UserInfo selectUserInfo(@Param("userInfo") UserInfo userInfo);
}
