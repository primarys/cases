package com.github.cases.RPC01.serviceCenter;

import java.io.IOException;

/**
 * @Author: jiang tongxue
 * @Date: 2018/12/28 12:15
 * @Version 1.0
 */
public interface Server {

    void stop();

    void start() throws IOException;

    void register(Class serviceInterface, Class impl);

    boolean isRunning();

    int getPort();

}
