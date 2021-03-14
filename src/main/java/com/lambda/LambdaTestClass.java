package com.lambda;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-4-25 10:43:52
 */

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda表达式的左侧为参数列表，右侧为lambda体，为对接口中抽象方法的实现。
 *
 *
 * */
public class LambdaTestClass {
    public static void main(String[] args) {
        Runnable r  = () -> System.out.println("hello, lambda!");
        r.run();

        new Thread(()-> System.out.println("一段可以传递的代码。。。")).start();


        Consumer<String> consumer = (x)-> System.out.println(x);
        consumer.accept("厉害！！！");

        //有返回值时要用大括号
        Comparator<Integer> com = (x, y)-> (x-y);
        /* {
            System.out.println("有返回值时必须要用大括号");
            return (x-y);
        };
        int compare = com.compare(12, 10);
        System.out.println(compare);*/
    }
}
