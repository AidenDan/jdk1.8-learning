package com.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-6 17:08:14
 */
public class LocalClient {
    private static final Map<String, Person> personMap = new HashMap<>();

    public static Person getPerSon(String name){
        return personMap.get(name);
    }

    public static void setPerson(Person person){
        personMap.put(person.getName(), person);
    }
}
