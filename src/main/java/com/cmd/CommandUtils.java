package com.cmd;

import sun.rmi.runtime.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-1-26 21:56:49
 */
public class CommandUtils {

    public static List<String> execReturn(String cmd) {

        String line;
        List<String> list = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
            while ((line = bReader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            return null;
        }
        return list;
    }
}
