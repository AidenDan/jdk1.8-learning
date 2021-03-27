package com.thread;

/**
 * @author Aiden
 * @version 1.0
 * @description 死锁案例 两个线程相互获取对方的锁 就jps jstack查看线程死锁状态
 *
 * @date 2021-3-14 16:34:44
 */
public class DeadLock {
    private static final Object Lock_01 = new Object();
    private static final Object Lock_02 = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (Lock_01){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Lock_02) {
                    System.err.println(Thread.currentThread().getName());
                }
            }
        }).start();

        new Thread(()->{
            synchronized (Lock_02){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Lock_01) {
                    System.err.println(Thread.currentThread().getName());
                }
            }
        }).start();
    }
}
