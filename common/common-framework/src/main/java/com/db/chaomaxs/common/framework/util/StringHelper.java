package com.db.chaomaxs.common.framework.util;

/**
 *
 * @author xiaofeng
 * @date 2017/9/10
 */
public class StringHelper {
	public static String getObjectValue(Object obj) {
		return obj == null ? "" : obj.toString();
	}
}
