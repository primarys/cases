package com.github.cases.Reflection09.fun2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/18 14:56
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class Person {

    private String name;
    private Integer age;
    private void introduce() {
        System.out.println("My name is " + name + ", I'm " + age + " years old!");
    }

}
