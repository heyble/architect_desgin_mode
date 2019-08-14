package com.demo.payment;

import com.demo.Order;
import com.demo.PayState;

public interface Payment {

    PayState pay(Order order);
}
