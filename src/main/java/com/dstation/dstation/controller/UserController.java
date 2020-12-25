package com.dstation.dstation.controller;

import com.alibaba.fastjson.JSONObject;
import com.dstation.dstation.domainModel.UserInfo;
import com.dstation.dstation.service.interf.IUserInfoService;
import com.dstation.dstation.util.Constant;
import com.dstation.dstation.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 登录界面
     * @return
     */
    @GetMapping("/loginAndRegister")
    public String intologinAndRegisterPage(){
        return "user/loginAndRegister";
    }


    /**
     * 保存用户信息
     * @param userInfo
     * @return
     */
    @PostMapping("/saveUserInfo")
    @ResponseBody
    public JSONObject saveUserInfo(UserInfo userInfo) {
        JSONObject jsonResult = new JSONObject();
        boolean isExist = userInfoService.findUserPhoneIsExist(userInfo.getUserPhone());
        if(isExist == true) {   //已经存在该手机号
            jsonResult.put("isExist", true);
            return jsonResult;
        } else {
            jsonResult.put("isExist", false);
            boolean saveResult = userInfoService.addUserInfo(userInfo); //添加用户
            if(saveResult == true) {
                jsonResult.put("saveResult", true);
            } else {
                jsonResult.put("saveResult", false);
            }
            return jsonResult;
        }
    }

    @RequestMapping("/queryUserInfo")
    @ResponseBody
    public JSONObject queryUserInfo(UserInfo userInfo, HttpSession session) {
        JSONObject jsonResult = new JSONObject();
        UserInfo queryUserInfo = userInfoService.findUserInfo(userInfo);
        System.out.println(queryUserInfo);
        if(queryUserInfo == null) {
            jsonResult.put("isExist", false);
        } else {
            session.setAttribute("userInfo", userInfo);
            jsonResult.put("isExist", true);
        }
        return jsonResult;
    }
}
