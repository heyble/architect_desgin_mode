package com.demo.payment;

import com.demo.Order;
import com.demo.PayState;

public class WechatPay implements Payment{

    public PayState pay(Order order) {
        System.out.println("欢迎使用微信支付");
        return new PayState(200,"支付成功",order.getAmount());
    }
}
