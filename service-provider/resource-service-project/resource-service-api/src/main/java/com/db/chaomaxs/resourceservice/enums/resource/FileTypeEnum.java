package com.db.chaomaxs.resourceservice.enums.resource;

import com.db.chaomaxs.common.framework.core.IntArrayValuable;
import java.util.Arrays;

/**
 * FileTypeEnum
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/27 13:59
 */
public enum FileTypeEnum implements IntArrayValuable {

  /**
   * 图片
   */
  IMAGE(1, "图片"),
  /**
   * 文件
   */
  FILE(2, "文件");

  public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(FileTypeEnum::getValue)
      .toArray();

  private final Integer value;
  private final String name;

  FileTypeEnum(Integer value, String name) {
    this.value = value;
    this.name = name;
  }

  public Integer getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  @Override
  public int[] array() {
    return ARRAYS;
  }
}
