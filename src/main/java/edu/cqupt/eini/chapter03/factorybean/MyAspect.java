package edu.cqupt.eini.chapter03.factorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author: Hello World
 * @date: 2018/8/1 16:29
 */
public class MyAspect implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        checkPermissions();
        Object obj = methodInvocation.proceed();
        log();
        return obj;
    }

    public void checkPermissions() {
        System.out.println("模拟检查权限...");
    }

    public void log() {
        System.out.println("模拟记录日志...");
    }
}
