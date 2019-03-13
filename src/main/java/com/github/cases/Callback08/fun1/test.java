package com.github.cases.Callback08.fun1;


/**
 * @Author: jiang tongxue
 * @Date: 2019/3/13 9:25
 * @Version 1.0
 */

//基本的回调
public class test {

    public static void main(String[] args) {
        Worker worker = new Worker();
        Manager manager = new Manager(worker);

        //manager.getFeedBack();
    }


}
