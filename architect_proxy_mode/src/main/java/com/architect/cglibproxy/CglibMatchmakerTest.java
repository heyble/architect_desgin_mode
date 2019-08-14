package com.architect.cglibproxy;

import com.architect.Person;

public class CglibMatchmakerTest {
    public static void main(String[] args) {
        CglibMatchmaker matchmaker = new CglibMatchmaker(new Jax());
        Person proxy = matchmaker.getProxy();
        proxy.findLove();
//        int sum = proxy.study(55, 2);
//        System.out.println(sum);
    }
}
