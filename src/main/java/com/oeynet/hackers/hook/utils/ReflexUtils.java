package com.oeynet.hackers.hook.utils;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ZengYinan.
 * Date: 2019/3/22 17:22
 * Email: 498338021@qq.com
 * Desc:
 */
public class ReflexUtils {

    public interface OnReflexInterface{
        Object onResult(Object[] objects);
    }

    //接口调用
    public static Object getInterfaceInstance(ClassLoader classLoader, Class interfacezz, final String methodName, final OnReflexInterface onReflexInterface) {
        Object classInstance = Proxy.newProxyInstance(classLoader, new Class[]{interfacezz}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if(method.getName().equals(methodName)){
                    return onReflexInterface.onResult(objects);
                }else{
                    return method.invoke(o, objects);
                }
            }
        });
        return classInstance;
    }

    //获取数组类Class
    public static Class getArrayClass(Class clazz) {
        return Array.newInstance(clazz, 0).getClass();
    }

    public static Object[] getArrayObject(Class clazz, Object[] data) {
        Object[] objArr = (Object[]) Array.newInstance(clazz, data.length);
        for (int i = 0; i < data.length; i++) {
            objArr[i] = data[i];
        }
        return objArr;
    }
}
