package com.demo.payment;

import com.demo.Order;
import com.demo.PayState;

public class OrderService {

    public static PayState pay(Order order, PayType payType){
        return payType.getPayment().pay(order);
    }
}
