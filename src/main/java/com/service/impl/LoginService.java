//package com.service.impl;
//
//import com.service.common.Result;
//import com.service.model.User;
//import com.service.utils.LocalCacheClient;
//import org.apache.commons.lang.StringUtils;
//
///**
// * @author Aiden
// * @version 1.0
// * @description
// * @date 2021-2-28 20:39:40
// */
//public class LoginService {
//    private final static String REGX = "^[a-zA-Z]\\w{5,17}$";
//
//    private String login(String username, String password) {
//        // 用户名或密码为空 失败
//        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
//            return Result.getFailResult();
//        }
//
//        // 密码格式不对
//        if (!password.matches(REGX)) {
//            return Result.getFailResult();
//        }
//
//        // 连续三次用户名密码不对
//        Integer errCount = LocalCacheClient.getErrCount(username);
//        if (!LocalCacheClient.isExistUser(username)) {
//            if (errCount >= 3) {
//                return Result.getFailResult();
//            }
//        }
//
//        // 获取一个用户
//        User user = LocalCacheClient.getUserByName(username, password);
//        return null;
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
