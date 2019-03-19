package com.github.cases.Reflection09.fun1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/18 10:58
 * @Version 1.0
 */


/**
 * 案例1：获取类名、方法、属性已经构造函数等基本信息
 */
public class DumpMethodsConstructorsFields {

        public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
            /* Returns the Class object associated with the classname */
            Class<?> clazz = Class.forName("java.util.Stack");
            Class<?> clazz1 = Class.forName("java.io.FileInputStream", true, java.io.FileInputStream.class.getClassLoader());
            System.out.println(clazz);
            System.out.println(clazz1);
            System.out.println("--------interfaces------");
            Class<?>[] interfaces = clazz.getInterfaces();
            for(Class<?> iClass : interfaces) {
                System.out.println(iClass.getName());
            }
            System.out.println("--------------");
            /*
             *  获取所有声明的方法（不包括构造函数），public，protected，缺省和private类型，
             *  包括返回类型、方法名，参数和抛出异常.
             *  getDeclaredMethods():获得类的所有方法。
             */
            Method[] methods = clazz.getDeclaredMethods();
            for(Method m : methods) {
                System.out.println(m);
            }
            System.out.println("--------------");

            /*
             * getMethods():获得类的 public 类型的方法。
             */
            Method[] methods1 = clazz1.getMethods();
            for(Method m : methods1) {
                System.out.println(m);
            }
            System.out.println("--------------");

            /*
             * getMethod(String name, Class[] parameterTypes):获得类的特定方法,
             * name 参数指定方法的名字
             * parameterTypes 参数指定方法的参数类型。
             * 获取：public int java.io.FileInputStream.read(byte[],int,int) throws java.io.IOException
             */
            Method method = clazz1.getMethod("read", new Class[]{byte[].class, int.class, int.class});
            System.out.println(method);
            System.out.println("-------public Constructors-------");

            Constructor<?>[] publicConstructors = clazz1.getConstructors();
            for(Constructor<?> c : publicConstructors) {
                System.out.println(c);
            }
            System.out.println("-------constructors-------");
            Constructor<?>[] constructors = clazz1.getDeclaredConstructors();
            for(Constructor<?> c : constructors) {
                System.out.println(c);
            }

            System.out.println("--------------");
            /* 根据参数数组获取指定的public型构造函数*/
            Constructor<?> constructor = clazz1.getConstructor(new Class[]{java.io.File.class});
            System.out.println(constructor);

            System.out.println("-------public field-------");
            /* 获得类的所有public类型的属性。*/
            Field[] fields = clazz1.getFields();
            for(Field field : fields) {
                System.out.println(field);
            }
            System.out.println("-------field-------");
            /* 获得类的所有属性。*/
            Field[] fields1 = clazz1.getDeclaredFields();
            for(Field field : fields1) {
                System.out.println(field);
            }

            System.out.println("-------field's setters and getters methods-------");
            /*
             * 获取属性的set和get方法
             * 我们不能直接获取setter和getter方法，需要获取到所有的方法，
             * 再进行循环选择。注意对于boolean类型，默认采用的是isXxx()
             */
            Class<?> clazz2 = Class.forName("java.util.Stack");
            Method[] methods2 = clazz2.getMethods();
            for(Method m : methods2) {
                if (isGetter(m))
                    System.out.println(m);
                if (isSetter(m))
                    System.out.println(m);
            }
        }


        public static boolean isGetter(Method method) {
            String methodName = method.getName();
            Class<?> returnType = method.getReturnType();
            Class<?> parameterTypes[] = method.getParameterTypes();
            if(returnType.equals(void.class)) {
                return false;
            }
            if ( (methodName.startsWith("get") || methodName.startsWith("is"))
                    && parameterTypes.length == 0) {
                return true;
            }
            return false;
        }

        public static boolean isSetter(Method method) {
            String methodName = method.getName();
            Class<?> parameterTypes[] = method.getParameterTypes();

            if (methodName.startsWith("set") && parameterTypes.length == 1) {
                return true;
            }
            return false;
        }
    }

