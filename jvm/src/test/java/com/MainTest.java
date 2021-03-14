package com;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-1-21 20:47:12
 */
public class MainTest {

    @Test
    public void testList(){
        Map<String, Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("qwe");
        list.add("qwe");
        list2.add("jki");
        list2.add("jki");
        map.put("list", list);
        list = list2;
        System.err.println(map.get("list"));
    }
}
