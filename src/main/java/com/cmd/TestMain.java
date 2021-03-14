package com.cmd;

import java.io.IOException;
import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-1-26 21:58:55
 */
public class TestMain {
    public static void main(String[] args) {
        List<String> tasklists = CommandUtils.execReturn("tasklist");
        tasklists.forEach(System.err::println);
    }
}
