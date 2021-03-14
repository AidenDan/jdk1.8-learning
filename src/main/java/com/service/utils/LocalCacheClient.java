///*
//package com.service.utils;
//
//import com.service.model.User;
//
//import java.util.HashMap;
//import java.util.Map;
//
//*/
///**
// * @author Aiden
// * @version 1.0
// * @description
// * @date 2021-2-28 20:41:18
// *//*
//
//public class LocalCacheClient {
//    private final static Map<String, User> userMap = new HashMap<>();
//    private final static Map<String, Integer> errCountMap = new HashMap<>();
//
//    public static boolean isExistUser(String username) {
//        return userMap.containsKey(username);
//    }
//
//    public static User getUserByName(String username, String password) {
//        if (userMap.containsKey(username)) {
//            return userMap.get(username);
//        } else {
//            // 此时这个用户还没有被放入到缓存中
//            User user = new User();
//            user.setUsername(username);
//            user.setPassword(password);
//            return user;
//        }
//    }
//
//    public static Integer getErrCount(String username) {
//        Integer count = errCountMap.get(username);
//        if (count == null) {
//            count = 0;
//        } else {
//            count = count + 1;
//        }
//        errCountMap.put(username, count);
//        return count;
//    }
//}
//*/
