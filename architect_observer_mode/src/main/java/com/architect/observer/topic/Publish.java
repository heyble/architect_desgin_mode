package com.architect.observer.topic;

import com.architect.observer.core.EventType;

public class Publish extends ObserverListener{

    public String send(String msg){
        System.out.println("发送消息："+msg);
        trigger(EventType.ON_PUBLISH);
        return "send OK";
    }

    public void add(Object entity){
        System.out.println("添加对象："+entity);
        trigger(EventType.ON_ADD);
    }


}
