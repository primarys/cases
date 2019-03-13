package com.github.cases.Callback08.fun2;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/13 9:42
 * @Version 1.0
 */
public class test {

    public static void main(String[]args){
        /**
         * new 一个小李
         */
        Li li = new Li();

        /**
         * new 一个小王
         */
        Wang wang = new Wang(li);

        /**
         * 小王问小李问题
         */
        wang.askQuestion("1 + 1 = ?");
    }

}
