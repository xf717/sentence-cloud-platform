package com.db.chaomaxs.systemservice.enums.dict;

import org.apache.commons.lang3.StringUtils;
/**
 * @description: 字典类枚举
 * @author wst
 * @date 2021/4/16 11:18
 */

public enum DataDictionaryEnum {
  /**
   * 技能掌握程度
   */
  SKILL_MASTERY(1L, "10001"),
  /**
   * 求职状态
   */
  JOB_SEARCHING_STATUS (2L, "10002"),
  /**
   * 求职方常用语
   */
  COMMON_PHRASES_FOR_JOB_SEEKERS (3L, "10003"),
  /**
   * 求职方打招呼语
   */
  GREETINGS_FROM_JOB_APPLICANTS(4L, "10004"),
  /**
   * 人员规模
   */
  STAFF_SIZE(5L, "10005"),
  /**
   * 融资阶段
   */
  FINANCING_STAGE(6L, "10006"),
  /**
   * 休息时间
   */
  BREAK_TIME(7L, "10007"),
  /**
   * 加班情况
   */
  OVERTIME(8L, "10008"),
  /**
   * 招聘方常用语
   */
  COMMON_PHRASES_USED_BY_RECRUITERS(9L, "10009"),
  /**
   * 招聘方打招呼语
   */
  GREETINGS_FROM_THE_RECRUITER(10L, "10010"),
  /**
   * 薪资范围
   */
  SALARY_RANGE(11L, "10011"),
  /**
   *工作经验
   */
  WORK_EXPERIENCE(12L, "10012"),
  /**
   *学历
   */
  EDUCATION(13L, "10013"),
  /**
   *积分说明
   */
  POINTS_DESCRIPTION(14L, "10014"),
  /**
   *积分类型
   */
  POINTS_TYPE(15L, "10015"),
  /**
   *通知发布类型
   */
  NOTIFICATION_TYPE(16L, "10016"),
  /**
   *通知显示方式
   */
  NOTIFICATION_DISPLAY_METHOD(17L, "10017"),
  /**
   *问题分类
   */
  QUESTION_CATEGORY(18L, "10018"),
  /**
   *热门城市
   */
  POPULAR_CITIES(19L, "10019"),
  /**
   *发布平台
   */
  PUBLISHING_PLATFORM(20L, "10020"),
  /**
   *学校
   */
  UNIVERSITY(21L, "10021");


  private Long key;
  private String value;

  DataDictionaryEnum(Long key, String value) {
    this.key = key;
    this.value = value;
  }

  public Long getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }

  public static DataDictionaryEnum getKey(String value) {
    if (StringUtils.isEmpty(value)) {
      return null;
    }
    DataDictionaryEnum[] values = DataDictionaryEnum.values();
    for (DataDictionaryEnum dataDictionaryEnum : values) {
      if (dataDictionaryEnum.getValue().equals(value)) {
        return dataDictionaryEnum;
      }
    }
    return null;
  }

  public static DataDictionaryEnum getValue(Long key) {
    if (null == key) {
      return null;
    }
    DataDictionaryEnum[] values = DataDictionaryEnum.values();
    for (DataDictionaryEnum dataDictionaryEnum : values) {
      if (dataDictionaryEnum.getKey().equals(key)) {
        return dataDictionaryEnum;
      }
    }
    return null;
  }
}
