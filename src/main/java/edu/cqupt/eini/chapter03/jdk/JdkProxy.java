package edu.cqupt.eini.chapter03.jdk;

import edu.cqupt.eini.chapter03.aspect.MyAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: Hello World
 * @date: 2018/7/31 17:12
 */
public class JdkProxy implements InvocationHandler {
    private UserDao userDao;

    public Object creatProxy(UserDao userDao) {
        this.userDao = userDao;
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        Class[] clazz = userDao.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, clazz, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyAspect myAspect = new MyAspect();
        myAspect.checkPermissions();
        Object obj = method.invoke(userDao, args);
        myAspect.log();
        return obj;
    }
}
