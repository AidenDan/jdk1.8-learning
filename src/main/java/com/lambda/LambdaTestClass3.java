package com.lambda;

import com.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-5-1 14:48:43
 */
@SuppressWarnings("all")
public class LambdaTestClass3 {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person(213, "张三"),
                new Person(34, "李四"),
                new Person(98, "王五"),
                new Person(16, "赵六"),
                new Person(899, "孙七"),
                new Person(213, "胡巴"),
                new Person(464, "玖拾"));
        //map用于提取集合中元素信息，提取每一个Person的年纪组成一个新的列表
        //在经过提取后的列表中取出最小值
        Optional<Integer> collectMin = list
                .stream()
                .map(Person::getAge)
                .collect(Collectors.minBy(Integer::compare));
        //integerStream.forEach(System.out::println);
        System.out.println(collectMin.get());

        //
        list.stream().forEach(p-> System.out.println(p));
        list.stream().forEach(System.out::println);
        list.stream().forEach(var ->{
            System.out.println(var);
        });
        List<String> collectList = list
                .stream()
                .map(person -> {
            return person.getName();
        })
                .collect(Collectors.toList());
        System.err.println("colectList--->"+collectList);

        List<Person> personList = list.stream().filter(person -> {
            return person.getAge() > 400;
        }).collect(Collectors.toList());
        System.out.println("personList--->"+personList);
    }
}
