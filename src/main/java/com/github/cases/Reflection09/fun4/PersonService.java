package com.github.cases.Reflection09.fun4;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/18 15:24
 * @Version 1.0
 */
public class PersonService {

    private List<Person> persons = new ArrayList<>();
    public String add(Person p) {
        persons.add(p);
        return "add-done";
    }

    public Person get(int i) {
        return persons.get(i);
    }
}
