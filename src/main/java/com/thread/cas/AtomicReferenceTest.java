package com.thread.cas;

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
public class AtomicReferenceTest {
    private static final LogManager logManager = LogManager.getLogManager();
    private static final Logger log = logManager.getLogger("");

    public static void main(String[] args) throws InterruptedException {
        // 带版本号的原子引用，可以探测到是否发生了A->B->A过程，如果发了ABA问题，那么A->C过程就不会执行成功
        AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);

        // 主内存中的值, 这个值可能会被其他线程修改
        String memoryValue = ref.getReference();
        String expectValue = memoryValue;
        // 获取主存中的版本号
        int memoryStamp = ref.getStamp();

        other(ref);
        Thread.sleep(1000);
        // 当期望值与内存中的值一致时, 同时
        // 当期望的版本号与主存中版本号一致compareAndSet方法执行成功
        log.log(Level.INFO, "更新:A->C:::" + ref.compareAndSet(expectValue, "C", memoryStamp, memoryStamp + 1));
        System.err.println("版本号:::" + ref.getStamp());
    }

    // 假如这个时候其他的线程也更新了A这个值
    public static void other(AtomicStampedReference<String> ref) {
        // 更新A->B
        new Thread(() -> {
            log.info("更新:A->B:::" + ref.compareAndSet(ref.getReference(), "B", ref.getStamp(), ref.getStamp() + 1));
        }).start();

        // 更新B->A
        new Thread(() -> {
            log.info("更新:B->A:::" + ref.compareAndSet(ref.getReference(), "A", ref.getStamp(), ref.getStamp() + 1));
        }).start();
    }
}
