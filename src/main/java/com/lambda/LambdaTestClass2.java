package com.lambda;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-4-25 10:43:52
 */

import com.entity.Person;
import com.function.MyFunctionInterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * lambda表达式的左侧为参数列表，右侧为lambda体，为对接口中抽象方法的实现。
 *
 *
 * */
public class LambdaTestClass2 {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person(213, "张三"),
                new Person(34, "李四"),
                new Person(98, "王五"),
                new Person(16, "赵六"),
                new Person(899, "孙七"),
                new Person(213, "胡巴"),
                new Person(464, "玖拾"));
//先按年纪比，年纪相同就按名字比
        Collections.sort(list, (p1, p2)->{
            if(p1.getAge().equals(p2.getAge())){
                return p1.getName().compareTo(p2.getName());
            }else {
                return p1.getAge().compareTo(p2.getAge());
            }
        });
        System.out.println(list);

        //函数接口，替换匿名内部类，并实现了抽象方法
        MyFunctionInterface my = (x, y, z)->{
            System.out.println(x+y+z);
            return x+y+z;
        };
        my.getSum(1,2,3);

        //stream Api
        //把集合转变成流对象，然后操作流
        Stream<Person> personStream = list.stream();

        long count = personStream.count();
        /*personStream.limit(3)
                                .filter((p)->{
                                    System.out.println("中间操作");
                                    return p.getAge()<100;
                                })
                                .forEach(System.out::println);*/

        personStream.map((x)->{
                                System.out.println("中间操作--->"+x.getAge());
                                return x.getAge();
                                 }).forEach(System.out::println);
    }
}
