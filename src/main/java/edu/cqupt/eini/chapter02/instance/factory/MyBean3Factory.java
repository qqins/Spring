package edu.cqupt.eini.chapter02.instance.factory;

/**
 * @author: Hello World
 * @date: 2018/7/23 11:06
 */
public class MyBean3Factory {
    public MyBean3Factory() {
        System.out.println("beans3工厂实例化中");
    }

    public Beans3 createBean() {
        return new Beans3();
    }
}
