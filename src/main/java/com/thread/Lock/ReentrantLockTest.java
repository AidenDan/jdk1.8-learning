package com.thread.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-14 19:46:51
 */


public class ReentrantLockTest {
    private final static Lock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        try {
            // 尝试获取一把可以打断的锁
            // 获取不到抛出异常
            reentrantLock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        try {
            System.err.println( "获取锁成功");
        } finally {
            // 释放锁
            reentrantLock.unlock();
        }
    }
}
