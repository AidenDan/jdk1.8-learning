package com.thread.pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-27 11:53:28
 */
public class TestPool {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                3,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                (runner, poolExecutor) -> {
//                    runner.run();
                    throw new RuntimeException("pool is maxing");
                });

        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.submit(() -> {
                System.err.println("hhh");
            });
        }
        threadPoolExecutor.shutdown();


        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(1,
                3,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10),
                (runner) -> new Thread(new ThreadGroup("my-thread-group"), runner, "name" + atomicInteger.getAndIncrement()),
                (runner, poolExecutor) -> {
                    throw new RuntimeException("pool is maxing");
                }
        );

    }
}
