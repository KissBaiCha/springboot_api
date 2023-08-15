package com.ly.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * ClassName: DateTools
 * Package: com.ly.hotel.webconfigservice.common.utils
 * Description : 日期工具类
 *
 * @Author : Xu Zhang
 * @CreateDate : 2023/4/4 - 10:27
 * @Version : 1.0
 */
public class DateTools {
    /**
     * 默认的日期时间格式
     */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 默认的日期格式
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 默认的时间格式
     */
    public static final String TIME_FORMAT = "HH:mm:ss";
    /**
     * 格式化日期
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return 格式化后的日期字符串
     */
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }
    /**
     * 格式化日期
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return 格式化后的日期字符串
     */
    public static String formatDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 格式化时间
     *
     * @param time    时间
     * @param pattern 时间格式
     * @return 格式化后的时间字符串
     */
    public static String formatTime(LocalTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 格式化日期时间
     *
     * @param dateTime 日期时间
     * @param pattern  日期时间格式
     * @return 格式化后的日期时间字符串
     */
    public static String formatDateTime(LocalDateTime dateTime, String pattern) {
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }
    /**
     * 解析日期
     *
     * @param dateTime 日期字符串
     * @param pattern    日期格式
     * @return 解析后的日期
     */
    public static Date paseDate(String dateTime, String pattern) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.parse(dateTime);
    }

    /**
     * 解析日期
     *
     * @param dateString 日期字符串
     * @param pattern    日期格式
     * @return 解析后的日期
     */
    public static LocalDate parseDate(String dateString, String pattern) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 解析时间
     *
     * @param timeString 时间字符串
     * @param pattern    时间格式
     * @return 解析后的时间
     */
    public static LocalTime parseTime(String timeString, String pattern) {
        return LocalTime.parse(timeString, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 解析日期时间
     *
     * @param dateTimeString 日期时间字符串
     * @param pattern        日期时间格式
     * @return 解析后的日期时间
     */
    public static LocalDateTime parseDateTime(String dateTimeString, String pattern) {
        return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前日期
     *
     * @return 当前日期
     */
    public static LocalDate now() {
        return LocalDate.now();
    }

    /**
     * 获取当前时间
     *
     * @return 当前时间
     */
    public static LocalTime currentTime() {
        return LocalTime.now();
    }

    /**
     * 获取当前日期时间
     *
     * @return 当前日期时间
     */
    public static LocalDateTime currentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前时间戳
     *
     * @return 当前时间戳
     */
    public static long currentTimestamp() {
        return Instant.now().toEpochMilli();
    }

    /**
     * 判断是不是同一天
     *
     * @param day1 day1
     * @param day2 day2
     * @return 是否同一天
     */
    public static boolean isSameDay(Date day1, Date day2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(day1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(day2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static LocalDate convertDateToLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static LocalTime convertDateToLocalTime(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalTime();
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime date) {
        return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date convertLocalDateToDate(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * @param date1 date1
     * @param date2 date2
     * @param unit  时间单位
     * @return 返回相差的时间单位整数
     */
    public static long compareDates(LocalDate date1, LocalDate date2, ChronoUnit unit) {
        switch (unit) {
            case NANOS:
            case MICROS:
            case MILLIS:
            case SECONDS:
            case MINUTES:
            case HOURS:
            case HALF_DAYS:
                LocalDateTime dateTime1 = LocalDateTime.of(date1, LocalDateTime.MIN.toLocalTime());
                LocalDateTime dateTime2 = LocalDateTime.of(date2, LocalDateTime.MIN.toLocalTime());
                return unit.between(dateTime1, dateTime2);
            case DAYS:
                return Period.between(date1, date2).getDays();
            case WEEKS:
                return Period.between(date1, date2).getDays() / 7;
            case MONTHS:
                return Period.between(date1, date2).toTotalMonths();
            case YEARS:
                return Period.between(date1, date2).getYears();
            default:
                throw new UnsupportedOperationException("Unsupported unit: " + unit);
        }
    }

    public static Date addYear(Date date, int amount) {
        return addDateTime(date, Calendar.YEAR, amount);
    }

    public static Date addMouth(Date date, int amount) {
        return addDateTime(date, Calendar.MONTH, amount);
    }

    public static Date addDay(Date date, int amount) {
        return addDateTime(date, Calendar.DAY_OF_MONTH, amount);
    }

    public static Date addHour(Date date, int amount) {
        return addDateTime(date, Calendar.HOUR_OF_DAY, amount);
    }

    public static Date addMinute(Date date, int amount) {
        return addDateTime(date, Calendar.MINUTE, amount);
    }

    /**
     * 按timeUnitType粒度增加时间
     * ps:YEAR = 1
     * MONTH = 2
     * WEEK_OF_YEAR = 3
     * WEEK_OF_MONTH = 4
     * DAY_OF_MONTH = 5
     * DAY_OF_YEAR = 6
     * DAY_OF_WEEK = 7
     * DAY_OF_WEEK_IN_MONTH = 8
     * AM_PM = 9
     * HOUR = 10
     * HOUR_OF_DAY = 11
     * MINUTE = 12
     * SECOND = 13
     * MILLISECOND = 14
     *
     * @param date         日期
     * @param timeUnitType ps
     * @param amount       偏移量
     * @return 改变后日期
     */
    public static Date addDateTime(Date date, int timeUnitType, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(timeUnitType, amount);
        return calendar.getTime();
    }

}
