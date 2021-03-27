package com.thread.finalTest;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-24 22:22:58
 */
public class Condition {
    private String serial;
    private int count;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "serial='" + serial + '\'' +
                ", count=" + count +
                '}';
    }
}
