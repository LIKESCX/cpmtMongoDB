package com.example.demo.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 时间格式转换工具类
 */
public class TimeConvertor {

	/**
	 * yyyy/MM/dd HH:mm:ss，正斜杠，24小时
	 */
	public static final String FORMAT_SLASH_24HOUR = "yyyy/MM/dd HH:mm:ss";
	// public static final String CURRENT_SLASH_24HOUR = "yyyy:MM:dd HH:mm:ss";

	/**
	 * yyyy-MM-dd HH:mm:ss，减号，24小时
	 */
	public static final String FORMAT_MINUS_24HOUR = "yyyy-MM-dd HH:mm:ss";

	/**
	 * yyyy-MM-dd，减号
	 */
	public static final String FORMAT_MINUS_DAY = "yyyy-MM-dd";
	
	
	public static final String FORMAT_DAY = "yyyyMMdd";

	/**
	 * yyyyMMddHHmmss，无符号，24小时
	 */
	public static final String FORMAT_NONSYMBOL_24HOUR = "yyyyMMddHHmmss";
	
	/**
	 * yyyyMMddHHmmss，无符号，24小时,毫秒级
	 */
	public static final String FORMAT_NONSYMBOL_24HOUR_SSS = "yyyyMMddHHmmssSSS";
	
	/**
	 * yyyyMMddHHmm，无符号，24小时
	 */
	public static final String FORMAT_NONSYMBOL_24HOUR_NOSEC = "yyyyMMddHHmm";

	/**
	 * yyyy/mm/dd hh24:mi:ss，Oracle用，正斜杠，24小时
	 */
	public static final String FORMAT_ORACLE_SLASH_24HOUR = "yyyy/mm/dd hh24:mi:ss";

	/**
	 * HH:mm:ss，24小时
	 */
	public static final String FORMAT_24HOUR = "HH:mm:ss";

	/**
	 * 一些常量定义
	 */

	/**
	 * 一天毫秒数
	 */
	public static final long ONE_DAY_MS = 24 * 60 * 60000;

	/**
	 * 一周毫秒数
	 */
	public static final long ONE_WEEK_MS = 7 * 24 * 60 * 60000;

	/**
	 * 一小时毫秒数
	 */
	public static final long ONE_HOUR_MS = 60 * 60000;

	/**
	 * 一分钟毫秒数
	 */
	public static final int ONE_MINUTE_MS = 60000;

	/**
	 * 一小时分钟数
	 */
	public static final int ONE_HOUR_MINUTE = 60;

	/**
	 * 一天小时数
	 */
	public static final int ONE_DAY_HOUR = 24;

	/**
	 * 起始年
	 */
	public static final int BASE_YEAR = 1900;

	/**
	 * 把一个时间的字符串根据输入格式和输出格式进行转换
	 * <p>
	 * 
	 * <pre>
	 * 支持至少三种格式之间的互相转换 
	 * yyyyMMddHHmmss 
	 * yyyy-MM-dd HH:mm:ss 
	 * yyyy/MM/dd HH:mm:ss
	 * </pre>
	 * 
	 * @param rawTimeStr
	 *            输入的原始时间字符串
	 * @param inputPattern
	 *            输入的原始时间格式
	 * @param outPattern
	 *            输出的原始时间格式
	 * @return 转换后的时间字符串
	 */
	public static String formatTimeStr(String rawTimeStr, String inputPattern,
			String outPattern) throws ParseException {
		if (inputPattern == null) {
			throw new IllegalArgumentException("inputPattern is null.");
		}
		if (outPattern == null) {
			throw new IllegalArgumentException("outPattern is null.");
		}
		if (rawTimeStr == null) {
			throw new IllegalArgumentException("rawTimeStr is null.");
		}
		SimpleDateFormat formatIn = new SimpleDateFormat(inputPattern);
		SimpleDateFormat formatOut = new SimpleDateFormat(outPattern);

		return formatOut.format(formatIn.parse(rawTimeStr));
	}

	/**
	 * 计算结束时间和开始时间的间隔(毫秒数)
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return 结束时间和开始时间的间隔(毫秒数)
	 */
	public static long timeGap(long startTime, long endTime) {
		return (endTime - startTime);
	}

	/**
	 * 获取当前系统时间(毫秒数)
	 * 
	 * @return 当前系统时间(毫秒数)
	 */
	public static long getCurrentTime() {
		return System.currentTimeMillis();
	}

	/**
	 * 字符串格式的时间转换为长整型
	 * 
	 * @param time
	 *            字符串格式的时间
	 * @param pattern
	 *            格式化字符串，如yyyy/MM/dd HH:mm:ss
	 * @return 长整型时间
	 */
	public static long stringTime2long(String time, String pattern) {
		if (time == null) {
			throw new IllegalArgumentException("time is null.");
		}
		if (pattern == null) {
			throw new IllegalArgumentException("pattern is null.");
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			Date date = format.parse(time);
			return date.getTime();
		} catch (ParseException e) {
			return 0L;
		}
	}

	/**
	 * 将长整型表示的时间转换成符合格式条件的时间字符串
	 * 
	 * @param time
	 *            长整型表示的时间
	 * @param pattern
	 *            格式化字符串，如yyyy/MM/dd HH:mm:ss
	 * @return 符合格式的时间字符串
	 */
	public static String longtime2String(long time, String pattern) {
		if (pattern == null) {
			throw new IllegalArgumentException("pattern is null.");
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date(time));
	}



	/**
	 * 用给定显示格式对Date对象表示的时间进行转换
	 * 
	 * @param time
	 *            Date对象
	 * @param pattern
	 *            格式化字符串，如yyyy/MM/dd HH:mm:ss
	 * @return 符合缺省显示格式的时间字符串
	 */
	public static String date2String(Date time, String pattern) {
		if (time == null) {
			throw new IllegalArgumentException("time is null.");
		}
		if (pattern == null) {
			throw new IllegalArgumentException("pattern is null.");
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(time);
	}



	/**
	 * 根据给定格式对字符串表示的时间，转换为Date对象
	 * 
	 * @param time
	 *            字符串形式的时间
	 * @param pattern
	 *            格式化字符串，如yyyy/MM/dd HH:mm:ss
	 * @return Date对象
	 */
	public static Date stringTime2Date(String time, String pattern) {
		if (pattern == null) {
			throw new IllegalArgumentException("pattern is null.");
		}
		if (time == null) {
			throw new IllegalArgumentException("time is null.");
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(time);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E" "yyyyMMddHHmmss"
	 */
//	public static String getDate(String pattern) {
//		return DateFormatUtils.format(new Date(), pattern);
//	}

}

