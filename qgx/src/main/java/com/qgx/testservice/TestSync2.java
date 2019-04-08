package com.qgx.testservice;

/**
 * ***************************
 * 类说明
 * ***************************
 *
 * @author: qgx
 * @date: 2019-04-08 22:52
 */
public class TestSync2 implements Runnable{

    /**
     * 可以深入了解同步锁
     * 1.不加锁：线程1和线程2相互交错执行，而且num会错乱
     * 2.方法锁：锁住add方法（在add方法前加锁），此时线程1和2还是相互交错执行，不过num
     *           由于加了锁可以顺序输出
     * 3.类锁：锁住整个run方法，即同一时间只能同一线程执行，且num顺序输出。
     *
     * 类锁力度大，范围广，不过不推荐
     */

    Timer timer = new Timer();
    public static void main(String[] args) {
        TestSync2 test = new TestSync2();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 0;i<20;i++){
            timer.add(Thread.currentThread().getName());
        }

    }
}
