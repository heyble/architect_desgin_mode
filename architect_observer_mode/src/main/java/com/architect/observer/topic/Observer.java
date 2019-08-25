package com.architect.observer.topic;

import com.architect.observer.core.Event;

public class Observer {

    public Object advice(Event event){
        System.out.println("*****************触发事件*******************");
        System.out.println(event);
        System.out.println("********************************************");
        return "trigger event";
    }
}
