package com.maruko.mall.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author xiaofeng
 * 创建时间:2019/4/19 13:25
 */
public class DateUtil {

	public static final String DATE_TIME_PATTERN = "yyyyMMddHHmmss";

	private static final String DATE_PATTERN = "yyyyMMdd";

	private static final String YEAR_MONTH_PATTERN = "yyyyMM";

	/**
	 * 获取有当前时间
	 * @return
	 */
	public static Long getCurrentTime() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
		return new Long(LocalDateTime.now().format(dateTimeFormatter));
	}

	/**
	 * 获取当前日期
	 * @return
	 */
	public static Long getCurrentDate() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
		return new Long(LocalDateTime.now().format(dateTimeFormatter));
	}

	/**
	 * 获取当前年月
	 * @return
	 */
	public static Integer getYearMonth() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(YEAR_MONTH_PATTERN);
		return new Integer(LocalDateTime.now().format(dateTimeFormatter));
	}

}
