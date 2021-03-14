package com.function;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-4-25 14:21:05
 */


/**
 * 函数式接口中只能有一个抽象方法
 *
 * */
@FunctionalInterface
public interface MyFunctionInterface {

    int getSum(int x, int y, int z);

}
