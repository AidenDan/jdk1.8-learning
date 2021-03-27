package com.thread.Lock;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-14 22:35:22
 */

public class synchronizedTest {
    private static final Object LOCK = new Object();
    private static boolean isT2Runed = false;
    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
            // 两个线程，指定线程2先于线程1执行
         Thread t1= new Thread(()->{
             synchronized (LOCK){
                 while (!isT2Runed){
                     try {
                         LOCK.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 Map<String, Object> map = threadLocal.get();
                 if (map  ==null){
                     map = new HashMap<>();
                 }
                 Integer value = (Integer) map.get("key");
                 if (value == null){
                     value = 10;
                 } else {
                     value++;
                 }
                 map.put("key", value);
                 threadLocal.set(map);
                 System.err.println("t1");
             }
         });

       Thread t2 = new Thread(()->{
            synchronized (LOCK){
                System.err.println("t2");
                isT2Runed = true;
                Map<String, Object> map = threadLocal.get();
                if (map == null){

                    map = new HashMap<>();
                }
                Integer value = (Integer) map.get("key");
                if (value == null){
                    value = 10;
                } else {
                    value++;
                }
                map.put("key", value);
                threadLocal.set(map);
                LOCK.notify();
            }
        });

       t1.start();
       t2.start();

       // 等待t1 t2 执行完毕
        t2.join();
        t1.join();

        System.err.println(threadLocal);
        Map<String, Object> map = threadLocal.get();
        System.err.println(map);
    }
}
