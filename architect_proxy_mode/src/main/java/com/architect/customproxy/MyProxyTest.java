package com.architect.customproxy;

import com.architect.Person;
import com.architect.jdkproxy.Lisi;

public class MyProxyTest {
    public static void main(String[] args) throws Exception {
        MyMatchmaker myMatchmaker = new MyMatchmaker(new Lisi());
        Person proxy = myMatchmaker.getProxy();
        proxy.findLove();



    }

}
