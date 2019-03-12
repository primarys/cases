package com.github.cases.dynamicProxy07;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/12 21:38
 * @Version 1.0
 */

/**
 * Object invoke(Object proxy, Method method, Object[] args) throws Throwable
 * proxy:　　指代我们所代理的那个真实对象
 * method:　　指代的是我们所要调用真实对象的某个方法的Method对象
 * args:　　指代的是调用真实对象某个方法时接受的参数
 *
 *public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) throws IllegalArgumentException
 * loader:  一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
 * interfaces:  一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
 * h:  一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
 */

public class test {

    public static void main(String[] args)
    {
        //    我们要代理的真实对象
        Subject realSubject = new RealSubject();

        //    我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);

        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        Subject subject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                                                          realSubject.getClass().getInterfaces(),
                                                          handler);

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getName());

        subject.rent();//先去调用InvocationHandler的invoke方法
        subject.hello("world");//同理
    }
}
