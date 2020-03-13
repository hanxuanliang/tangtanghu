package com.hxl.core.utils;

import java.util.Date;

/**
 * 日期工具类
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/12 12:53
 */
public class DateUtil {

    /**
     * @Description: 获得过期时间
     * @param: duration 延时时间，单位s
     * @date: 2020/3/12 12:57  
     */
    public static Date getDurationDate(long duration) {
        long expireTime = System.currentTimeMillis() + duration * 1000;
        return new Date(expireTime);
    }
}
