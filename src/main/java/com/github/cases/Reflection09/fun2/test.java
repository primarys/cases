package com.github.cases.Reflection09.fun2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/18 14:57
 * @Version 1.0
 */


/**
 * 案例2：获取类的私有属性和私有方法
 */
public class test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        System.out.println("-------private fields and methods-------");
        Person person = new Person("SunnyMarkLiu", 22);
        System.out.println("name:" + person.getName());
        Field privateField = Person.class.getDeclaredField("name");
        // !important 设置标志为true后，被反射的类会抑制java的访问检查机制
        privateField.setAccessible(true);
        privateField.set(person, "HasChanged!");
        System.out.println("反射修改后：" + person.getName());

        Method privateMethod = Person.class.getDeclaredMethod("introduce", new Class[]{});
        // !important 设置标志为true后，被反射的类会抑制java的访问检查机制
        privateMethod.setAccessible(true);
        try {
            privateMethod.invoke(person, new Object[]{});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
