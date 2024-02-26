package com.ly.service.impl;

import com.ly.entity.InstalmentInfoDTO;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
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
        String str = "044G44_Oe4U0uB_7gNq5GHsNGInWcXlvTPvNQdJ-kixGXEb";
    }
    public static InstalmentInfoDTO getInstallmentCost(BigDecimal totalPrincipal, int instalmentNum, double taxRate, boolean interestFree){
        // 计算每期本金
        BigDecimal principalPerInstalment = totalPrincipal.divide(BigDecimal.valueOf(instalmentNum), 2, BigDecimal.ROUND_DOWN);

        // 计算总手续费
        BigDecimal totalCommission = totalPrincipal.multiply(BigDecimal.valueOf(taxRate));

        //对总手续费进行取整。取整规则为 ROUND_HALF_EVEN；
        totalCommission = totalCommission.setScale(1,BigDecimal.ROUND_HALF_EVEN);

        // 计算每期手续费
        BigDecimal commissionPerInstalment = totalCommission.divide(BigDecimal.valueOf(instalmentNum), 2, BigDecimal.ROUND_DOWN);

        // 计算每期总金额
        BigDecimal totalAmountPerInstalment = principalPerInstalment.add(commissionPerInstalment);

        //总分期费用 本金 + 手续费
        BigDecimal allTotalAmount = interestFree ? totalPrincipal : totalPrincipal.add(totalCommission);

        InstalmentInfoDTO instalmentInfoDTO = new InstalmentInfoDTO();
        // 将计算结果设置回instalmentInfoDTO中
        instalmentInfoDTO.setPrincipal(principalPerInstalment.doubleValue());
        instalmentInfoDTO.setTotalCommission(totalCommission.doubleValue());
        instalmentInfoDTO.setCommission(commissionPerInstalment.doubleValue());
        instalmentInfoDTO.setTotalAmount(totalAmountPerInstalment.doubleValue());
        instalmentInfoDTO.setAllTotalAmount(allTotalAmount.doubleValue());

        return instalmentInfoDTO;
    }

    public static String getSubCookieParam(String cookieValue, String cookieParam) {
        String result = "";

        int lastIndex = cookieValue.lastIndexOf(cookieParam);
        int startIndex = (lastIndex >= 0) ? lastIndex + cookieParam.length() : -1;

        if (startIndex >= 0) {
            int endIndex = cookieValue.indexOf("&", startIndex);
            if (endIndex >= 0) {
                result = cookieValue.substring(startIndex, endIndex);
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
