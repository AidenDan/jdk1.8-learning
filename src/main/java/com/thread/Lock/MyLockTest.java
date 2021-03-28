package com.thread.Lock;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-28 18:12:42
 */
public class MyLockTest {
    public static void main(String[] args) {
        MyLock lock = new MyLock();
        new Thread(()->{
            try {
                lock.lock();
                System.err.println("locking---One");
                Thread.sleep(20000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.err.println("release---locking---One");
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            try {
                lock.lock();
                System.err.println("locking---Two");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.err.println("release---locking---Two");
                lock.unlock();
            }
        }).start();
    }
}
