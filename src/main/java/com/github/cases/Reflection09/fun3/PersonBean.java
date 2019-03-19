package com.github.cases.Reflection09.fun3;

import lombok.Data;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/18 15:12
 * @Version 1.0
 */
@Data
public class PersonBean implements Person {

    private String name;
    private Integer age;

    public PersonBean() {}

    public PersonBean(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void info() {
        System.out.println(this.name + ":" +this.age);
    }
}
