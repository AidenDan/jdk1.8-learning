package com.thread;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-7 20:30:26
 */
public class TicketTest {
    // 总计1000张
    // 加锁保证对共享变量的原子操作，cpu在执行原子代码块时，不会切换去调度执行其他线程
    private static int NUM = 1000;

    public static void main(String[] args) {
        // 3个窗口同时开始出售，并行操作
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    if (NUM > 0) {
                        synchronized (TicketTest.class) {
                            NUM--;
                            if (NUM <= 0) {
                                break;
                            }
                            System.err.println("窗口" + finalI + ":总的票数还剩:::" + NUM);
                        }
                    } else {
                        break;
                    }
                }
            }).start();
        }
    }
}
