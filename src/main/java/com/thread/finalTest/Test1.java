package com.thread.finalTest;

import sun.security.util.Resources;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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

        InputStream inp = Test1.class.getResourceAsStream("/test.properties");

        System.err.println("inp:::"+inp);
//        Files.copy(Paths.get(""), Paths.get(""));
    }

    public static void testBiFunction(BiFunction<Integer, Integer, Integer> biFunction){
        Integer res = biFunction.apply(8, 9);
        System.err.println(res);
    }
}
