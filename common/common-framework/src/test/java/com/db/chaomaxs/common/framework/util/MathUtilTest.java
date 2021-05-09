package com.db.chaomaxs.common.framework.util;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import java.util.Random;
import org.junit.Test;

/**
 * MathUtilTest
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/07 14:30
 */
public class MathUtilTest {

  @Test
  public void should_random() {

    for (int i = 0; i <= 100; i++) {
//      int result = RandomUtil.randomInt(10000,10000);
//      int result = MathUtil.random(1, 10000);
//      String result = getRandomCode(6);
      String result = code();
      System.out.println(result);
    }
  }

  public static String code() {
    String[] codees = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String code = "";
    for (int i = 0; i < 6; i++) {
      int j = (int) (Math.random() * 10);
      code += codees[j];
    }
    return code;
  }

  public static String getRandomCode(int count) {
    char[] codeSequence = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    StringBuilder randomCode = new StringBuilder();
    // 生成随机数
    Random random = new Random();
    randomCode.append(random.nextInt(9) + 1);
    for (int i = 1; i < count; i++) {
      String strRand = String.valueOf(codeSequence[random
          .nextInt(codeSequence.length)]);
      randomCode.append(strRand);
    }
    return randomCode.toString();
  }

}
