package com.architect.jdkproxy;

import com.architect.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class  JdkMatchmaker implements InvocationHandler{

    private Person target;

    public JdkMatchmaker(Person target) {
        this.target = target;
    }

    public  Person getProxy(){
        return (Person) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk代理开始工作");
        System.out.println("调用目标类方法");
        Object returnValue = method.invoke(target,args);
        System.out.println("调用完毕，返回值为："+returnValue);
        return returnValue;
    }
}
