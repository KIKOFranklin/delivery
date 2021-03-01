package com.mochasoft.deliverycore.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 时间工具类.
 */
public final class DateUtil {
    /**
     * 默认格式化格式.
     */
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 包含日期级时分秒格式.
     */
    public static final String YYYYMMDDHHMMSS_FORMAT = "yyyyMMddHHmmss";

    /**
     * 只包含日期格式化格式.
     */
    public static final String YYYY_MM_DD_FORMAT = "yyyy-MM-dd";

    /**
     * 只包含日期格式化格式.
     */
    public static final String YYYY_MM_FORMAT = "yyyy-MM";

    /**
     * 只包含年份的格式.
     */
    public static final String YYYY_FORMAT = "yyyy";
    /**
     * 其他日期格式化格式.
     */
    public static final String DAY_FORMAT = "yyyyMMdd";

    /**
     * 其他日期格式化格式.
     */
    public static final String MONTH_FORMAT = "yyyy-MM";

    /**
     * 其他日期格式化格式.
     */
    public static final String DAY_FORMAT_SEC = "yyMMdd";

    /**
     * 其他日期格式化格式.
     */
    public static final String DAY_FORMAT_THI = "MMddyy";

    /**
     * 私有构造器.
     */
    private DateUtil() {

    }

    /**
     * 获取当前默认日期格式输出.
     * @return 日期字符串
     */
    public static String getTimeYYYYMMDDHHmm() {
        return getCurrentTime(DEFAULT_FORMAT);
    }

    /**
     * 获取当前其他日期格式输出.
     * @return 日期字符串.
     */
    public static String getTimeYYYYMMDD() {
        return getCurrentTime(YYYY_MM_DD_FORMAT);
    }

    /**
     * 获取当前年份.
     * @return
     */
    public static String getTimeYYYY() {
        return getCurrentTime(YYYY_FORMAT);
    }

    /**
     * 获取当前系统时间.
     * @param format 日期格式
     * @return 日期字符串.
     */
    public static String getCurrentTime(final String format) {
        final DateTimeFormatter ftf = DateTimeFormatter.ofPattern(format);
        return ftf.format(LocalDateTime.now());
    }

    /**
     * 获取当前系统时间时间戳.
     * @return 返回时间戳
     */
    public static String getCurrentTimeLong() {
        return String.valueOf(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    /**
     * 将日期转换为指定字符串格式.
     *
     * @param date 输入日期时间
     *
     * @param format 输入转换格式 "yyyy-MM-dd","MM/dd/yyyy"
     *
     * @return 返回日期字符串
     */
    public static String formatDate(final LocalDate date, final String format) {
        if (Objects.isNull(date)) {
            return null;
        }
        final DateTimeFormatter ftf = DateTimeFormatter.ofPattern(format);
        return ftf.format(date);
    }

    /**
     * 将日期转换为指定字符串格式.
     *
     * @param dateTime 输入日期时间
     *
     * @param format 输入转换格式 "yyyy-MM-dd","MM/dd/yyyy"
     *
     * @return 返回日期字符串
     */
    public static String formatTime(final LocalDateTime dateTime, final String format) {
        if (Objects.isNull(dateTime)) {
            return null;
        }
        final DateTimeFormatter ftf = DateTimeFormatter.ofPattern(format);
        return ftf.format(dateTime);
    }

    /**
     * 把字符串转换成日期.
     * @param dateTime 输入字符型日期，如2008-12-30
     * @param format 输入排序规则，如"yyyy-MM-dd","MM/dd/yyyy" 根据上面字符串日期，规格应选择yyyy-MM-dd
     * @return 返回日期
     *
     */
    public static LocalDateTime parseTime(final String dateTime, final String format) {
        final DateTimeFormatter ftf = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateTime, ftf);
    }

    /**
     * 把字符串转换成日期.
     * @param date 输入字符型日期，如2008-12-30
     * @param format 输入排序规则，如"yyyy-MM-dd","MM/dd/yyyy" 根据上面字符串日期，规格应选择yyyy-MM-dd
     * @return 返回日期
     *
     */
    public static LocalDate parseDate(final String date, final String format) {
        final DateTimeFormatter ftf = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(date, ftf);
    }

    /**
     * 转换date格式为LocalDate.
     * @param date date数据
     * @param format 格式
     * @return 返回localDateTime
     */
    public static String parseDateToStr(final Date date, final String format) {
        ZoneId zoneId = ZoneId.systemDefault();
        return formatTime(LocalDateTime.ofInstant(date.toInstant(), zoneId), format);
    }

    /**
     * 获取指定日期周几.
     * @param date 日期
     * @param format 格式化日期格式
     * @return 返回星期数
     */
    public static String getWeekNum(final String date, final String format) {
        //定义日期格式
        LocalDate now = DateUtil.parseDate(date, format);
        return String.valueOf(now.getDayOfWeek().getValue());
    }
    /**
     * 获取指定日期所在周的周一.
     * @param date 输入字符型日期
     * @param format 输入排序规则
     * @return 返回日期
     */
    public static LocalDate getThisWeekMonday(final String date, final String format) {
        //定义日期格式
        LocalDate now = DateUtil.parseDate(date, format);
        //获取本周一的日期
        return now.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1);
    }

    /**
     * 获取指定日期所在周的周日.
     * @param date 输入字符型日期
     * @param format 输入排序规则
     * @return 返回日期
     */
    public static LocalDate getThisWeekSunday(final String date, final String format) {
        //定义日期格式
        LocalDate now = DateUtil.parseDate(date, format);
        //获取本周日的日期
        return now.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1);
    }

    /**
     * 获取当前日期这一年的最后一天.
     * @return 返回日期
     */
    public static LocalDate getThisYearEnd() {
        return LocalDate.now().plusYears(1).with(TemporalAdjusters.firstDayOfYear()).minusDays(1);
    }

    /**
     * 根据当前日期获得几天后的日期.
     * @param date 输入字符型日期
     * @param format 输入排序规则
     * @param afterDays 几天后
     * @return 返回日期
     */
    public static String getDaysAfter(final String date, final String format, long afterDays) {
        //定义日期格式
        LocalDate now = DateUtil.parseDate(date, format);
        //获取本周日的日期
        return formatDate(now.plusDays(afterDays), YYYY_MM_DD_FORMAT);
    }

    /**
     * 根据当前日期获得几天前的日期.
     * @param date 输入字符型日期
     * @param format 输入排序规则
     * @param afterDays 几天前
     * @return 返回日期
     */
    public static String getDaysBefore(final String date, final String format, long afterDays) {
        //定义日期格式
        LocalDate now = DateUtil.parseDate(date, format);
        //获取本周日的日期
        return formatDate(now.minusDays(afterDays), YYYY_MM_DD_FORMAT);
    }


    /**
     * 获取指定月份的所有日期稽核.
     * @param queryMonth 结束日期
     * @return 返回间隔日期
     */
    public static List<LocalDate> getBetweenDate(final String queryMonth) {
        LocalDate currentDate = DateUtil.parseDate(queryMonth, DateUtil.YYYY_MM_DD_FORMAT);
        LocalDate firstDate = currentDate.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDate = currentDate.with(TemporalAdjusters.lastDayOfMonth());
        return getBetweenDate(firstDate, lastDate);
    }

    /**
     * 获取两个日期间隔的所有日期,包括两端的日期.
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 返回间隔日期
     */
    public static List<LocalDate> getBetweenDate(LocalDate startDate, LocalDate endDate) {
        return Optional.of(ChronoUnit.DAYS.between(startDate, endDate))
            .filter(t -> t >= 1)
            .map(
                t -> Stream.iterate(startDate, d -> d.plusDays(1))
                    .limit(t + 1)
                    .collect(Collectors.toList())
            )
            .orElse(Collections.emptyList());
    }

    public static Date localDate2Date(LocalDate localDate) {
        if (null == localDate) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 获得给定日期所属一周内的最后一天及第一天.
     * @param  date 给定日期时间
     * @return 返回给定日期的周一及周日
     */
    public static Map<String, String> getStartEndDate(final String date) {
        Map<String, String> map = new HashMap<>();
        map.put("start", DateUtil.getThisWeekMonday(date, DateUtil.YYYY_MM_DD_FORMAT).toString());
        map.put("end", DateUtil.getThisWeekSunday(date, DateUtil.YYYY_MM_DD_FORMAT).toString());
        return map;
    }

    /**
     * 获得给定日期map(用于手机端查询当天的所有数据).
     * @param  date 给定日期时间
     * @return 返回给定日期map
     */
    public static Map<String, String> getDate(final String date) {
        Map<String, String> map = new HashMap<>();
        map.put("start", date);
        map.put("end", date);
        return map;
    }

    /**
     * 获得给定日期(星期三、星期五)map(用于手机端查询当天的所有数据).
     * @param  date 给定日期时间
     * @return 返回给定日期map
     */
    public static Map<String, String> getDateWenFri(final String date) {
        Integer dayOfWeek = Integer.valueOf(getWeekNum(date,"yyyy-MM-dd"));
        if(dayOfWeek < 3){
            LocalDate paramDate = parseDate(date,"yyyy-MM-dd");
            LocalDate wednesday = paramDate.with(TemporalAdjusters.nextOrSame( DayOfWeek.WEDNESDAY));
            return getDate(formatDate(wednesday,"yyyy-MM-dd"));
        }else if(dayOfWeek == 4){
            LocalDate paramDate = parseDate(date,"yyyy-MM-dd");
            LocalDate friday = paramDate.with(TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY));
            return getDate(formatDate(friday,"yyyy-MM-dd"));
        }else if(dayOfWeek > 5){
            LocalDate paramDate = parseDate(date,"yyyy-MM-dd");
            LocalDate wednesday = paramDate.with(TemporalAdjusters.nextOrSame( DayOfWeek.WEDNESDAY));
            return getDate(formatDate(wednesday,"yyyy-MM-dd"));
        }else if(dayOfWeek == 3 || dayOfWeek == 5){
            return getDate(date);
        }
        return null;
    }
}
