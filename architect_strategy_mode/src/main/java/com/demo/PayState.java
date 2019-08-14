package com.demo;

public class PayState {
    private Integer code;
    private String msg;
    private Double amount;

    public PayState(Integer code, String msg,Double amount) {
        this.code = code;
        this.msg = msg;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "支付完成{" +
                "状态：" + code +
                " 消息：" + msg + '\'' +
                " 金额：" + amount +
                '}';
    }
}
