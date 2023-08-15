package com.ly.service.impl;

import kotlin.text.Charsets;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassName: Test
 * Package: com.chixing.service.impl
 * Description : 在此写入类信息
 *
 * @Author : Xu Zhang
 * @CreateDate : 2023/7/25 - 10:57
 * @Version : 1.0
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        byte[] body = "版本3".getBytes();

        String str = new String(body,Charsets.UTF_8);
        log.info("str:{}",str);
    }
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static int distance(double fromLng, double fromLat, double toLng, double toLat) {
        double a, b, R;
        //地球半径
        R = 6378137;
        fromLat = fromLat * Math.PI / 180.0;
        toLat = toLat * Math.PI / 180.0;
        a = fromLat - toLat;
        b = (fromLng - toLng) * Math.PI / 180.0;
        double d;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(fromLat) * Math.cos(toLat) * sb2 * sb2));
        return (int) d;
    }
}
