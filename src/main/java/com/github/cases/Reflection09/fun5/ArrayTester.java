package com.github.cases.Reflection09.fun5;

import java.lang.reflect.Array;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/18 15:37
 * @Version 1.0
 */

/**
 * 案例5：Array 类提供了动态创建和访问数组元素的各种静态方法
 */
public class ArrayTester {

    public static void main(String args[]) throws Exception {
        // 设置数组的维度为
        int[] dims = new int[] { 5, 10, 15 };
        Class<?> classType = Class.forName("java.lang.String");
        Object array = Array.newInstance(classType, dims);
        Object arrayObj = Array.get(array, 3);
        Class<?> cls = arrayObj.getClass().getComponentType();
        System.out.println("ComponentType" + cls);
        // 使 arrayObj 引用 array[9][10]
        Object arrayObj1 = Array.get(arrayObj, 9);
        // 把元素 array[3][9][10]设为 hello
        Array.set(arrayObj1, 10, "hello");
        String arrayCast[][][] = (String[][][]) array;
        System.out.println(arrayCast[3][9][10]);

    }
}
