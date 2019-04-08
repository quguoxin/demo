package com.qgx.testservice;

/**
 * ***************************
 * 类说明
 * ***************************
 *
 * @author: qgx
 * @date: 2019-04-04 0:24
 */
public class TestSync implements Runnable{

    int b = 100;

    public synchronized void m1() throws Exception{
        System.out.println("C_"+Thread.currentThread().getName());
        b = 1000;
        Thread.sleep(5000);
        System.out.println("F_"+Thread.currentThread().getName());
        System.out.println("b = " + b);
    }

    public void m2() throws Exception {
        System.out.println("B_"+Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("D_"+Thread.currentThread().getName());
        System.out.println("m2里b的值： " + b);
        b = 2000;
    }

    @Override
    public void run() {
        try {
            m1();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("A_"+Thread.currentThread().getName());
        TestSync tt = new TestSync();
        Thread t = new Thread(tt);
        t.start();
        tt.m2();
        System.out.println("E_"+Thread.currentThread().getName());
        System.out.println(tt.b);
    }
}
