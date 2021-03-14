package com.thread;

import java.lang.management.ThreadInfo;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-10 22:06:42
 *
 * wait notify notifyAll必须和synchronize obj对象锁一起使用
 */
public class WaitNotifyTest {
    private final static Object LOCK = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (LOCK){
                try {
                    LOCK.wait(); // 等待状态并且释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.err.println("55645");
        new Thread(()->{
            synchronized (LOCK){
                LOCK.notifyAll(); // 唤醒所有处于等待状态中的线程
            }
        }).start();

        // Future
        Future<Integer> future = new FutureTask(()->{return 1;});
        String regx = "^(User[1-9]|[1-9]\\d|100)$";
        System.err.println("User1".matches(regx));
//        LockSupport.park();

    }
}
