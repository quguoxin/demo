package com.qgx.testservice;

/**
 * ***************************
 * 类说明
 * ***************************
 *
 * @author: qgx
 * @date: 2019-04-08 22:52
 */
public class TestSync1 {

    public static void main(String[] args) {
        Timer1 timer1 = new Timer1();
        Thread t3 = new Thread(timer1);
        Thread t4 = new Thread(timer1);

        t3.setName("t1");
        t4.setName("t2");
        t3.start();
        t4.start();
        timer1.run();

    }
}
