package com.github.xf717.common.framework.constant;


/**
 * 共公的变量
 *
 * @author xiaofeng
 */
public class CommonConstants {

  public final static String RESOURCE_TYPE_MENU = "menu";
  public final static String RESOURCE_TYPE_BTN = "button";
  // 用户token异常
  public static final Integer EX_USER_INVALID_CODE = 40101;
  public static final Integer EX_USER_PASS_INVALID_CODE = 40001;
  // 客户端token异常
  public static final Integer EX_CLIENT_INVALID_CODE = 40301;
  public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
  public static final Integer EX_OTHER_CODE = 500;
  public static final String CONTEXT_KEY_USER_ID = "currentUserId";
  public static final String CONTEXT_KEY_COMPANY_ID = "currentCompanyId";
  public static final String CONTEXT_KEY_USERNAME = "currentUserName";
  public static final String CONTEXT_KEY_USER_NAME = "currentUser";
  public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";
  public static final String JWT_KEY_USER_ID = "userId";
  public static final String JWT_KEY_NAME = "name";
  public static final String JWT_ID = "id";

  /**
   * UTF-8 字符集
   */
  public static final String UTF8 = "UTF-8";

  /**
   * GBK 字符集
   */
  public static final String GBK = "GBK";
}
