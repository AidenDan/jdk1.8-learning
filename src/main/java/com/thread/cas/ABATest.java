package com.thread.cas;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author Aiden
 * @version 1.0
 * @description cas是乐观锁思想的实现(其实没有锁), synchronized, Lock锁是悲观锁的实现
 * @date 2021-3-21 20:46:23
 */

public class ABATest {
    private static final LogManager logManager = LogManager.getLogManager();
    private static final Logger log = logManager.getLogger("");

    // cas操作中的ABA问题
    // A->C的过程中经历了A->B->A的过程
    // 定义一个String类型的原子引用, 初始值为A, 现在在多线程环境下把它修改为C
    private static AtomicReference<String> ref = new AtomicReference<>("A");

    public static void main(String[] args) throws InterruptedException {

        // 主内存中的值, 这个值可能会被其他线程修改
        String memoryValue = ref.get();
        String expectValue = memoryValue;
        other(ref);
        Thread.sleep(1000);
        // 当期望值与内存中的值一致时, compareAndSet方法执行成功
        log.log(Level.INFO, "更新:A->C:::" + ref.compareAndSet(expectValue, "C"));
    }

    // 假如这个时候其他的线程也更新了A这个值
    public static void other(AtomicReference<String> ref) {
        // 更新A->B
        new Thread(() -> {
            log.info("更新:A->B:::" + ref.compareAndSet(ref.get(), "B"));
        }).start();

        // 更新B->A
        new Thread(() -> {
            log.info("更新:B->A:::" + ref.compareAndSet(ref.get(), "A"));
        }).start();
    }
}
