package edu.cqupt.eini.chapter03.cglib;

import edu.cqupt.eini.chapter03.aspect.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: Hello World
 * @date: 2018/8/1 15:59
 */
public class CglibProxy implements MethodInterceptor {
    public Object createProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        MyAspect myAspect = new MyAspect();
        myAspect.checkPermissions();
        Object obj = methodProxy.invokeSuper(o, objects);
        myAspect.log();
        return obj;
    }
}
