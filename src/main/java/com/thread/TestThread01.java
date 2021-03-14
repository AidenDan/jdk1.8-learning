package com.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.LockSupport;

/**
 * 线程调用sleep方法，线程从running状态转变为阻塞状态，sleep时间结束前不会被cpu进行调度
 * 线程调用yield方法，线程从running状态转变为就绪状态，仍可能被cpu进行调度
 * synchronized对象锁，加锁代码块为原子代码块，不会在执行的时候发生cpu切换到其他线程，加锁方法为原子方法
 *
 * 无锁
 * 偏向锁是为了消除无竞争情况下的同步原语,进一步提升程序性能
 * cas轻量级锁，锁对象Markword关联线程栈帧中的锁记录  (锁膨胀--->)
 * 升级为重量级锁后，锁对象Markword关联操作系统Monitor，Monitor中的owner与当前线程关联
 *
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-7 14:11:26
 */
public class TestThread01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.err.println(args );
        // 多线程创建方法
        // 1、new thread重写run方法
        Thread thread01 = new Thread(){

            // 重写run方法
            @Override
            public void run(){
                System.err.println("thread01.....");

                CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                    return 1;
                });

                LockSupport.park();
            }
        };


        Thread.State state = thread01.getState();
        // 启动线程
        thread01.start();

        // 2、Thread整和Runnable
        Thread thread1 = new Thread(() -> {
            System.err.println(100);
        });
        thread1.start();

        // 3、Thread整和FutureTask实现多线程Callable
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            return 100;
        });
        Thread thread = new Thread(futureTask);
        thread.start();
        // 阻塞方法，thread执行完之前会一直阻塞在此
        Integer integer = futureTask.get();
        System.err.println(integer);
    }
}
