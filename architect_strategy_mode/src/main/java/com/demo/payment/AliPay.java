package com.demo.payment;

import com.demo.Order;
import com.demo.PayState;

public class AliPay implements Payment {
    public PayState pay(Order order) {
        System.out.println("欢迎使用支付宝");
        return new PayState(200,"支付成功",order.getAmount());
    }
}
