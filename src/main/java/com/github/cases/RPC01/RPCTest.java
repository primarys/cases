package com.github.cases.RPC01;

import com.github.cases.RPC01.serviceCenter.Server;
import com.github.cases.RPC01.serviceCenter.ServiceCenter;
import com.github.cases.RPC01.serviceClient.RPCClient;
import com.github.cases.RPC01.serviceProvider.HelloService;
import com.github.cases.RPC01.serviceProvider.HelloServiceImpl;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @Author: jiang tongxue
 * @Date: 2018/12/28 12:27
 * @Version 1.0
 */
public class RPCTest {

    public static void main(String[] args) throws IOException {

        //System.out.println(Runtime.getRuntime().availableProcessors());

        new Thread(new Runnable() {
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.getClass().getName());
        System.out.println(service.sayHi("test20181228"));
    }


}
