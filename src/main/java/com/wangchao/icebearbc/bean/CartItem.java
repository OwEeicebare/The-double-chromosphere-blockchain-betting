package com.wangchao.icebearbc.bean;

import lombok.Data;


/**
 * @Auther:WangChao
 * @ClassName:CartItem
 * @Date:Created in 2018/9/29 16:47
 * @Despriction:
 * @Modify By:
 */

@Data
public class CartItem {
    //红球
    private String red;
    //蓝球
    private String blue;
    //数量
    private int cout =1;
    //单价
    private double price=2;
    //小计
    private double subtotal ;

    public double getSubtotal(){
        return cout*price;
    }
}
