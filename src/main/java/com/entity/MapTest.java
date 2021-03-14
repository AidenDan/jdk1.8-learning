package com.entity;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-6 17:07:57
 */
public class MapTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Person person = new Person();
        person.setName("张三");
        person.setAge(18);
        LocalClient.setPerson(person);
        System.err.println("0:::"+LocalClient.getPerSon(person.getName()));

        person.setName("王五");

        System.err.println("1:::"+LocalClient.getPerSon(person.getName()));
        System.err.println("1:::"+LocalClient.getPerSon("张三"));

        LocalClient.setPerson(person);
        System.err.println("2:::"+LocalClient.getPerSon(person.getName()));

        Future<Integer> future = Executors.newCachedThreadPool().submit(new Callable<Integer>() {
            /**
             * Computes a result, or throws an exception if unable to do so.
             *
             * @return computed result
             * @throws Exception if unable to compute a result
             */
            @Override
            public Integer call() throws Exception {
                return null;
            }
        });

        Integer integer = future.get();
    }
}
