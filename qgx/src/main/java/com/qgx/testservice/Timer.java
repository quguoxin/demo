package com.qgx.testservice;

/**
 * ***************************
 * 类说明
 * ***************************
 *
 * @author: qgx
 * @date: 2019-04-08 22:50
 */
public class Timer {

    private static int num = 0;

    public void add(String name) {
        num++;
        /*try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }*/
        System.out.println(name + "你是第" + num + "个使用timer的线程");
    }
}
