package com.github.cases.Callback08.fun1;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/13 9:24
 * @Version 1.0
 */
public class Worker {

    /**
     * 业务参数+接口引用
     * @param str
     * @param callback
     */
    public void doItWork(String str, Callback callback){
        if (str !=null){
            System.out.println(str);
            callback.getFeedBack();
        }
    }

}
