package com.architect.staticproxy;

import com.architect.Person;

public class StaticMatchmaker {
    Person obj;

    public StaticMatchmaker(Person obj) {
        this.obj = obj;
    }

    public void findLove(){
        System.out.println("静态 红娘开始工作");
        System.out.println("帮你找对象，有什么要求：");
        obj.findLove();
        System.out.println("已匹配成功，请你确认");
    }

}
