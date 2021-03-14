package com.thread;

import com.entity.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-8 20:32:10
 */
public class MapTest {
    private static Person person = null;

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "James");
        map.computeIfPresent("name", (k, v) -> {
            map.remove(k);
            return k + v;
        });

        System.err.println(map);

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                synchronized (MapTest.class) {
                    Person person = getInstance();
                    Integer age = person.getAge();
                    person.setAge(1 + age);
                    System.err.println(person);
                }
            }).start();
        }
    }

    public static Person getInstance() {
        if (person == null) {
//            synchronized (MapTest.class) {
            if (person == null) {
                person = new Person();
            }
//            }
        }
        return person;
    }
}
