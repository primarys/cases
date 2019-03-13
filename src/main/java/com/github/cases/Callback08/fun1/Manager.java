package com.github.cases.Callback08.fun1;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/13 9:23
 * @Version 1.0
 */
public class Manager implements Callback {

    private Worker worker;  //获取B(秘书)的引用

    public Manager(Worker worker) {
        this.worker = worker;
        System.out.println("开始");
        worker.doItWork("整理公司文件",this); //这是B的方法，传入了A（老板）的引用
    }

    //回调方法
    public void getFeedBack() {
        System.out.println("事情已完成");
    }
}
