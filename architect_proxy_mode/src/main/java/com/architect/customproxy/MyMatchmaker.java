package com.architect.customproxy;

import com.architect.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyMatchmaker implements MyInvocationHandle {

    private Person target;

    public MyMatchmaker(Person target) {
        this.target = target;
    }

    public  Person getProxy(){
        return (Person) MyProxy.newProxyInstance(new MyClassloader(), target.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("jdk代理开始工作");
        System.out.println("调用目标类方法");
        Object returnValue = method.invoke(target,args);
        System.out.println("调用完毕，返回值为："+returnValue);
        return returnValue;
    }
}
