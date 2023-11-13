package com.ly.service.impl;

import com.google.common.base.Splitter;
import freemarker.template.utility.DateUtil;
import kotlin.text.Charsets;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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
        String cnUserValue = "userid=454116888&nickName=kissBaiCha&loginType=&token=203039007222250079029251141152081104137007081099038184122148137063086035091239211025013027087224158179018084075171109156216059178255106038018083098117007188090037179015137210057093003165082079167195154250047064086077023057017044170070000044161128034179157071255068205182183225230147070191033185014232231140106181&authcode=13524536F32DCE87A19835EF2BC517BC&secsign=88HnDXC7-ksml8NHzFgMI0xhMgK4fpiZsOImNOHThaPSKJzlqhHgUb2MH7ffRPB_Wd";

        log.info(subEncryptMemberIdForSecsign(cnUserValue,"token="));
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String format = formatter.format(date);
        System.out.println(format);

    }

    private static String subEncryptMemberIdForSecsign(String cnUserValue,String cookiePram) {

        int startIndex = cnUserValue.indexOf(cookiePram) + cookiePram.length();
        String result = "";
        if (startIndex >= 0) {
            if (cnUserValue.indexOf("&", startIndex) >= 0) {
                result = cnUserValue.substring(startIndex, cnUserValue.indexOf("&", startIndex));
            } else {
                result = cnUserValue.substring(startIndex);
            }
        }
        return result;
    }


    public static String getOneParameter(String url,String keyWord) {
        String retValue = "";
        try {
            final String charset = "utf-8";
            url = URLDecoder.decode(url, charset);
            if (url.indexOf('?') != -1) {
                final String contents = url.substring(url.indexOf('?') + 1);
                String[] keyValues = contents.split("&");
                for (String keyValue : keyValues) {
                    String key = keyValue.substring(0, keyValue.indexOf("="));
                    String value = keyValue.substring(keyValue.indexOf("=") + 1);
                    if (key.equals(keyWord)) {
                        retValue = value;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retValue;
    }
}
