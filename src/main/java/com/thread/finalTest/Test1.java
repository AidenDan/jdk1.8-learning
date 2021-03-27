package com.thread.finalTest;

import java.util.function.BiFunction;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-24 22:23:50
 */
public class Test1 {
    private static final Condition  condition = new Condition();
    public static void main(String[] args) {
        condition.setCount(1);
        condition.setSerial("sdf");
        System.err.println(condition);

        condition.setCount(2);
        condition.setSerial("jkl");
        System.err.println(condition);

        Class<Integer> type = Integer.TYPE;
        testBiFunction((p1, p2)-> p1+p2);
    }

    public static void testBiFunction(BiFunction<Integer, Integer, Integer> biFunction){
        Integer res = biFunction.apply(8, 9);
        System.err.println(res);
    }
}
