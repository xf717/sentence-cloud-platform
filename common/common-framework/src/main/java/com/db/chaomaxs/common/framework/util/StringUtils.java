package com.db.chaomaxs.common.framework.util;

import cn.hutool.core.lang.UUID;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class StringUtils {

  public static boolean hasText(String str) {
    return org.springframework.util.StringUtils.hasText(str);
  }

  public static String join(Collection<?> coll, String delim) {
    return org.springframework.util.StringUtils.collectionToDelimitedString(coll, delim);
  }

  public static List<String> split(String toSplit, String delim) {
    String[] stringArray = org.springframework.util.StringUtils
        .tokenizeToStringArray(toSplit, delim);
    return Arrays.asList(stringArray);
  }

  public static List<Integer> splitToInt(String toSplit, String delim) {
    String[] stringArray = org.springframework.util.StringUtils
        .tokenizeToStringArray(toSplit, delim);
    List<Integer> array = new ArrayList<>(stringArray.length);
    for (String string : stringArray) {
      array.add(Integer.valueOf(string));
    }
    return array;
  }

  public static String substring(String str, int start) {
    return org.apache.commons.lang3.StringUtils.substring(str, start);
  }

  public static String uuid(boolean isSimple) {
    return UUID.fastUUID().toString(isSimple);
  }

  /**
   * 生成随机码,可用于验证码
   *
   * @param count 随机位数
   * @return
   */
  public static String generateRandomCode(int count) {
    char[] codeSequence = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    StringBuilder builder = new StringBuilder();
    // 生成随机数
    Random random = new Random();
    builder.append(random.nextInt(9) + 1);
    for (int i = 1; i < count; i++) {
      String strRand = String.valueOf(codeSequence[random
          .nextInt(codeSequence.length)]);
      builder.append(strRand);
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    String password = StringUtils.uuid(true);
    System.out.println(password);
  }

}
