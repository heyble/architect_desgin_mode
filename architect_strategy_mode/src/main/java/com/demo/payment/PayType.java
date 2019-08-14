package com.demo.payment;

public enum PayType {
    ALIPAY(new AliPay()),WECHATPAY(new WechatPay());

    private Payment payment;

    PayType(Payment payment){
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }
}
