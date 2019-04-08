package com.qgx.testservice;

/**
 * ***************************
 * 类说明
 * ***************************
 *
 * @author: qgx
 * @date: 2019-04-08 22:50
 */
public class Timer1 implements Runnable {

    private static int num = 0;

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            num++;
            System.out.println(Thread.currentThread().getName() + "你是第" + num + "个使用timer的线程");

        }

    }
}
