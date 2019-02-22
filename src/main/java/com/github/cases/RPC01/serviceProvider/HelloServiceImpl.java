package com.github.cases.RPC01.serviceProvider;

/**
 * @Author: jiang tongxue
 * @Date: 2018/12/28 12:11
 * @Version 1.0
 */
public class HelloServiceImpl implements HelloService {

    public String sayHi(String name) {
        return "Hi, " + name;
    }

}
