package com.ly.service.impl;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

//        String[] arr = "epc,epcindex,eh5,tapphotel,eclockhotel,th5,yunshanfu,yunshanfuindex,addition,i-addition,tappaddition,tpc,tpcindex,baiduxiaochengxu,kuaiyingyong,toutiao,toutiaoindex,baiduxiaochengxuindex,kuaiyingyongindex,tappclockhotel,th5clockhotel,baiduxiaochengxuclockhotel,toutiaoclockhotel,kuaishou,kuaishouindex,dianjinghotel,qipaihotel,leisurehotel,leisurehotelindex,tleisurehotel,tappleisurehotel,douyin_lite,i-epc,i-epcindex,i-tpc,i-tpcindex,i-eh5,i-th5,i-baiduxiaochengxu,i-toutiao,i-kuaishou,i-douyin_lite,i-tgopc,toutiaoxcx,douyinxcx,toutiaoclockhotelxcx,douyinclockhotel,i-douyin,toutiao_lite,i-toutiao_lite,eminsu,tminsu,tappminsu,alipayxcx,alipayclockhotelxcx,alipayminsuxcx,alipayxcxindex,epchome,i-epchome,subwayxcx,subwayclockhotelxcx,subwayminsuxcx,i-subwayxcx,wxplugin,wxclockhotelplugin,wxminsuplugin,wxxcx,wxclockhotelxcx,wxminsuxcx,i-tapphotel,kuaiyingyongminsu,kuaiyingyongclockhotel,i-kuaiyingyong,i-alipayxcx,ikuaiyingyongindex,kuaiyingyongclockhotelindex,kuaiyingyongminsuindex,i-yunshanfu,alipayaddition,huixing".split(",");
//        String[] index = "eclockhotel,kuaiyingyong,i-kuaiyingyong,kuaiyingyongminsu,kuaiyingyongclockhotel,subwayxcx,alipayxcxindex,alipayxcx,alipayclockhotelxcx,alipayminsuxcx,tapphotel,tappclockhotel,tappminsu,i-tapphotel,eminsu,tminsu,subwayminsuxcx,wxminsuplugin,wxminsuxcx".split(",");
        String cnUserValue = "userid=1048732781&token=029200194120060239163017177246195236110107108221042028161090033060033085165180181239119055229176165137006189195199083084075190150121045087090063140125184244014050052084017242045104095157219174145100050172249109151127&loginType=passport&secsign=81DRqbkHAeTsSlvSt6ub4QNiEEqBAfQMmcaSed4vkUGkVRmhJu2PKPt-BD20YtG9l5&authcode=B71DDDAFC6A2D0BE3F90E69DF40A3957";

        log.info(getSubCookiePram(cnUserValue,"secsign="));

    }

    public static String getSubCookiePram(String cookieValue,String cookiePram) {
        int startIndex = cookieValue.indexOf(cookiePram) + cookiePram.length();
        String result = "";
        if (startIndex >= 0) {
            if (cookieValue.indexOf("&", startIndex) >= 0) {
                result = cookieValue.substring(startIndex, cookieValue.indexOf("&", startIndex));
            } else {
                result = cookieValue.substring(startIndex);
            }
        }
        return result;
    }
    // 方法接收集合数据和筛选条件的 Map
    public static <T> List<T> filterCollection(List<T> collection, Map<String, Object> filterMap) {
        List<T> filteredList = new ArrayList<>();

        for (T item : collection) {
            boolean isMatched = true;

            for (Map.Entry<String, Object> entry : filterMap.entrySet()) {
                try {
                    // 获取实体对象的属性值
                    Object propertyValue = item.getClass().getMethod("get" + capitalize(entry.getKey())).invoke(item);

                    // 检查实体对象的属性值是否符合筛选条件
                    if (!entry.getValue().equals(propertyValue)) {
                        isMatched = false;
                        break;
                    }
                } catch (Exception e) {
                    // 处理异常情况，可以根据实际情况进行处理或记录日志
                    isMatched = false;
                    break;
                }
            }

            if (isMatched) {
                filteredList.add(item);
            }
        }

        return filteredList;
    }

    // 辅助方法：将属性名的首字母大写，以便构造 getter 方法名
    private static String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
