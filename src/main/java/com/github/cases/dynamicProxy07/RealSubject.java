package com.github.cases.dynamicProxy07;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/12 21:33
 * @Version 1.0
 */
//实际的对象
public class RealSubject implements Subject{

    @Override
    public void rent()
    {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str)
    {
        System.out.println("hello: " + str);
    }


}
