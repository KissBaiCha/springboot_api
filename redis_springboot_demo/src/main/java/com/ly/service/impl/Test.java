package com.ly.service.impl;

import kotlin.text.Charsets;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        String[] arr = "epc,epcindex,eh5,tapphotel,eclockhotel,th5,yunshanfu,yunshanfuindex,addition,i-addition,tappaddition,tpc,tpcindex,baiduxiaochengxu,kuaiyingyong,toutiao,toutiaoindex,baiduxiaochengxuindex,kuaiyingyongindex,tappclockhotel,th5clockhotel,baiduxiaochengxuclockhotel,toutiaoclockhotel,kuaishou,kuaishouindex,dianjinghotel,qipaihotel,leisurehotel,leisurehotelindex,tleisurehotel,tappleisurehotel,douyin_lite,i-epc,i-epcindex,i-tpc,i-tpcindex,i-eh5,i-th5,i-baiduxiaochengxu,i-toutiao,i-kuaishou,i-douyin_lite,i-tgopc,toutiaoxcx,douyinxcx,toutiaoclockhotelxcx,douyinclockhotel,i-douyin,toutiao_lite,i-toutiao_lite,eminsu,tminsu,tappminsu,alipayxcx,alipayclockhotelxcx,alipayminsuxcx,alipayxcxindex,epchome,i-epchome,subwayxcx,subwayclockhotelxcx,subwayminsuxcx,i-subwayxcx,wxplugin,wxclockhotelplugin,wxminsuplugin,wxxcx,wxclockhotelxcx,wxminsuxcx,i-tapphotel,kuaiyingyongminsu,kuaiyingyongclockhotel,i-kuaiyingyong,i-alipayxcx,ikuaiyingyongindex,kuaiyingyongclockhotelindex,kuaiyingyongminsuindex,i-yunshanfu,alipayaddition,huixing".split(",");
        String[] index = "eclockhotel,kuaiyingyong,i-kuaiyingyong,kuaiyingyongminsu,kuaiyingyongclockhotel,subwayxcx,alipayxcxindex,alipayxcx,alipayclockhotelxcx,alipayminsuxcx,tapphotel,tappclockhotel,tappminsu,i-tapphotel,eminsu,tminsu,subwayminsuxcx,wxminsuplugin,wxminsuxcx".split(",");

        log.info(String.join(",", extractElements(Arrays.asList(arr), Arrays.asList(index))));
    }
    public static List<String> extractElements(List<String> a, List<String> b) {
        List<String> result = new ArrayList<>();
        for (String element : a) {
            if (!b.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
