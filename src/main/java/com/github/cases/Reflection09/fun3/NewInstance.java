package com.github.cases.Reflection09.fun3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/18 15:11
 * @Version 1.0
 */


/**
 * 案例3：通过调用构造方法创建一个新的对象
 */
public class NewInstance {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> clazz = Class.forName("com.github.cases.Reflection09.fun3.PersonBean");
        System.out.println(clazz);
        // 获取有参构造函数
        Constructor<?> constructor = clazz.getConstructor(new Class[]{String.class, Integer.class});
        PersonBean person = (PersonBean) constructor.newInstance(new Object[]{"SunnyMarkLiu", 20});
        person.info();
        // 获取无参构造函数
        Constructor<?> constructor1 = clazz.getConstructor(new Class<?>[]{});
        PersonBean person1 = (PersonBean) constructor1.newInstance(new Object[]{});
        person1.info();
    }
}
