package com.timain.web.utils;

import org.springframework.util.DigestUtils;

/**
 * md5加密
 * @Author: yyf
 * @Date: 2021/1/15 9:21
 * @Version: 1.0
 */
public class Md5Utils {

    public static String md5Pwd(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
