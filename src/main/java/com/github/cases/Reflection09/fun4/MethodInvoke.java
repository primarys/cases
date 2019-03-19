package com.github.cases.Reflection09.fun4;

import java.lang.reflect.Method;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/18 15:24
 * @Version 1.0
 */

/**
 * 案例4：运用反射机制调用对象的方法
 */
public class MethodInvoke {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("com.github.cases.Reflection09.fun4.PersonService");
        PersonService personService = (PersonService) clazz.getConstructor(new Class<?>[]{}).newInstance(new Object[]{});
        // 获取要调用的方法
        Method method = clazz.getMethod("add", new Class[]{Person.class});
        /*
         * 调用personService对象的method方法，同时传递参数。
         * 返回值result为调用该函数的返回值，如果函数返回类型为void，则result为null
         */
        Object result = method.invoke(personService,
                new Object[]{new Person("SunnyMarkLiu", 22)});
        System.out.println(result);
        Method method1 = clazz.getMethod("get", new Class[]{int.class});
        Object result1 = method1.invoke(personService,
                new Object[]{0});
        System.out.println(result1);

        Person p = (Person) result1;
        System.out.println(p.getName()+":"+p.getAge());
    }
}
