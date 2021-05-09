package com.db.chaomaxs.common.framework.context;

import com.db.chaomaxs.common.framework.constant.CommonConstants;
import com.db.chaomaxs.common.framework.util.StringHelper;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaofeng
 * @date 2017/9/8
 */
public class BaseContextHandler {

  public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

  public static void set(String key, Object value) {
    Map<String, Object> map = threadLocal.get();
    if (map == null) {
      map = new HashMap<String, Object>(1);
      threadLocal.set(map);
    }
    map.put(key, value);
  }

  public static Object get(String key) {
    Map<String, Object> map = threadLocal.get();
    if (map == null) {
      map = new HashMap<String, Object>(1);
      threadLocal.set(map);
    }
    return map.get(key);
  }

  public static String getUserID() {
    Object value = get(CommonConstants.CONTEXT_KEY_USER_ID);
    return returnObjectValue(value);
  }

  public static Long getUserId() {
    Object value = get(CommonConstants.CONTEXT_KEY_USER_ID);
    return Long.parseLong(returnObjectValue(value));
  }

  public static Long getCompanyId() {
    Object value = get(CommonConstants.CONTEXT_KEY_COMPANY_ID);
    return Long.parseLong(returnObjectValue(value));
  }

  public static String getUsername() {
    Object value = get(CommonConstants.CONTEXT_KEY_USERNAME);
    return returnObjectValue(value);
  }


  public static String getName() {
    Object value = get(CommonConstants.CONTEXT_KEY_USER_NAME);
    return StringHelper.getObjectValue(value);
  }

  public static String getToken() {
    Object value = get(CommonConstants.CONTEXT_KEY_USER_TOKEN);
    return StringHelper.getObjectValue(value);
  }

  public static void setToken(String token) {
    set(CommonConstants.CONTEXT_KEY_USER_TOKEN, token);
  }

  public static void setName(String name) {
    set(CommonConstants.CONTEXT_KEY_USER_NAME, name);
  }

  public static void setUserID(String userID) {
    set(CommonConstants.CONTEXT_KEY_USER_ID, userID);
  }

  public static void setUsername(String username) {
    set(CommonConstants.CONTEXT_KEY_USERNAME, username);
  }

  private static String returnObjectValue(Object value) {
    return value == null ? null : value.toString();
  }

  public static void remove() {
    threadLocal.remove();
  }
}
