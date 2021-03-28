package com.date;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-28 16:28:32
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        // LocalDateTime可获取日期时间
        LocalDateTime nowTime = LocalDateTime.now();
        System.err.println("nowTime:::" + nowTime);
        // 格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ss");
        String formatNowTime = dateTimeFormatter.format(nowTime);
        System.err.println("formatNowTime:::" + formatNowTime);
        // 获取一个时间
        LocalDateTime getOneTime = LocalDateTime.of(2021, 3, 10, 23, 0, 0);
        System.err.println("getOneTime:::" + dateTimeFormatter.format(getOneTime));
        // 时间的加减
        int year = nowTime.getYear();
        Month month = nowTime.getMonth();
        int value = month.getValue();
        int dayOfMonth = nowTime.getDayOfMonth();
        int hour = nowTime.getHour();
        int minute = nowTime.getMinute();
        int second = nowTime.getSecond();
        System.err.println("year:::" + year);
        System.err.println("month:::" + value);
        System.err.println("dayOfMonth:::" + dayOfMonth);
        System.err.println("hour:::" + hour);
        System.err.println("minute:::" + minute);
        System.err.println("second:::" + second);

        // 获取一个未来时间
        LocalDateTime future = nowTime.withYear(2022).withMonth(10).withDayOfMonth(1).withHour(10).withMinute(20).withSecond(20);
        String futureTime = dateTimeFormatter.format(future);
        System.err.println("futureTime:::" + futureTime);
        LocalDateTime plusMonths = nowTime.plusMonths(15);
        System.err.println("plusMonths:::" + dateTimeFormatter.format(plusMonths));
    }
}
