package com.ly.commons.utils;

/**
 * ClassName: LonAndLatUtil
 * Package: com.ly.commons.utils
 * Description : 在此写入类信息
 *
 * @Author : Xu Zhang
 * @CreateDate : 2023/8/15 - 10:15
 * @Version : 1.0
 */
public class LonAndLatUtil {
    /**
     * 计算两点之间的距离（单位：千米）
     * @param lat1 纬度1
     * @param lon1 经度1
     * @param lat2 纬度2
     * @param lon2 经度2
     * @return 距离
     */
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        int earthRadius = 6371; // 地球半径，单位为千米

        // 将经纬度转换为弧度
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // 使用Haversine公式计算两点间的直线距离
        double dlon = lon2Rad - lon1Rad;
        double dlat = lat2Rad - lat1Rad;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        return distance;
    }
}
