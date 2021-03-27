package com.thread.cas;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-22 21:59:34
 */
public class AtomicReferenceTest2 {
    private static final LogManager logManager = LogManager.getLogManager();
    private static final Logger log = logManager.getLogger("");

    public static void main(String[] args) throws InterruptedException {
        // 可以探测到是否发生了A->B->A过程，如果发了ABA操作那么A->C过程就会执行失败
        // 初始值为true，如果发生修改就设为false
        AtomicMarkableReference<String> ref = new AtomicMarkableReference<>("A", true);

        // 主内存中的值, 这个值可能会被其他线程修改
        String memoryValue = ref.getReference();
        String expectValue = memoryValue;

//        other(ref);
        Thread.sleep(1000);
        // 当期望值与内存中的值一致时, 同时
        // 当期望的版本号与主存中版本号一致compareAndSet方法执行成功
        log.log(Level.INFO, "更新:A->C:::" + ref.compareAndSet(expectValue, "C", true, false));
    }

    // 假如这个时候其他的线程也更新了A这个值
    public static void other(AtomicMarkableReference<String> ref) {
        // 更新A->B
        new Thread(() -> {
            log.info("更新:A->B:::" + ref.compareAndSet(ref.getReference(), "B", true, false));
        }).start();

        // 更新B->A
        new Thread(() -> {
            log.info("更新:B->A:::" + ref.compareAndSet(ref.getReference(), "A", true, false));
        }).start();
    }
}
