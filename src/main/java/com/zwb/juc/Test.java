package com.zwb.juc;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args)   {
        System.out.println(Runtime.getRuntime().availableProcessors());
        //获取CPU核数 12
        //CPU密集型 IO密集型

//        Thread.State
//        TimeUnit.SECONDS.sleep(1);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Test test = new Test();
        try {
            test.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
