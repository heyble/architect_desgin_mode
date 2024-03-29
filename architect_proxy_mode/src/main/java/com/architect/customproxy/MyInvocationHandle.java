package com.architect.customproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface MyInvocationHandle {
    Object invoke(Object proxy, Method method,Object[] args) throws InvocationTargetException, IllegalAccessException;
}
