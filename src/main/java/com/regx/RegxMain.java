package com.regx;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-2-25 21:27:46
 */
public class RegxMain {
    public static void main(String[] args) {
        String regx01 = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
        String regex = "[a-zA-Z_0-9]+@[a-zA-Z_0-9]+(\\.[A-Za-z]+)+";

        boolean matches = "223".matches(regex);
        System.err.println(matches);
    }
}
