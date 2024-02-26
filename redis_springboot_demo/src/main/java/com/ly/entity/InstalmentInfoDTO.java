package com.ly.entity;

/**
 * ClassName: InstalmentInfoDTO
 * Package: com.ly.entity
 * Description : 在此写入类信息
 *
 * @Author : Xu Zhang
 * @CreateDate : 2024/1/22 - 20:01
 * @Version : 1.0
 */
public class InstalmentInfoDTO {
//    @ApiModelProperty(value = "每期本金", required = true)
    private double principal;
    //@ApiModelProperty(value = "每期总金额", required = true)
    private double totalAmount;
    //@ApiModelProperty(value = "总分期金额", required = true)
    private double allTotalAmount;
    //@ApiModelProperty(value = "每期手续费", required = true)
    private double commission;
    //@ApiModelProperty(value = "总手续费", required = true)
    private double totalCommission;

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getAllTotalAmount() {
        return allTotalAmount;
    }

    public void setAllTotalAmount(double allTotalAmount) {
        this.allTotalAmount = allTotalAmount;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(double totalCommission) {
        this.totalCommission = totalCommission;
    }
}
