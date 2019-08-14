package com.architect.cglibproxy;

import com.architect.Person;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMatchmaker  implements MethodInterceptor{
    private Person target;

    public CglibMatchmaker(Person target) {
        this.target = target;
    }

    public Person getProxy(){
        return (Person) Enhancer.create(target.getClass(),this);
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 开始工作");
        System.out.println("调用目标类方法");
        Object retureValue = method.invoke(target, objects);
        System.out.println("调用完毕，返回值：" + retureValue);
        return retureValue;
    }
}
