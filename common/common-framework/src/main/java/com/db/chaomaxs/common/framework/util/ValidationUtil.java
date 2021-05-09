package com.db.chaomaxs.common.framework.util;

import cn.hutool.core.util.PhoneUtil;
import java.util.regex.Pattern;

/**
 * 校验工具类
 */
public class ValidationUtil {

  private static Pattern PATTERN_URL = Pattern
      .compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");

  public static boolean isMobile(String mobile) {
    if (mobile == null || mobile.length() != 11) {
      return false;
    }
    // 手机号码进行验证
    return PhoneUtil.isMobile(mobile);
  }

  public static boolean isURL(String url) {
    return StringUtils.hasText(url)
        && PATTERN_URL.matcher(url).matches();
  }

  public static void main(String[] args) {
    System.out.println(PhoneUtil.isMobile("19850050009"));
  }

}
