package com.github.xf717.searchservice.dal.es;

/**
 * ES 字段分析器的枚举类
 * <p>
 * 关于 IK 分词，文章 https://blog.csdn.net/xsdxs/article/details/72853288 不错。 目前项目使用的 ES 版本是 6.7.1 ，可以在
 * https://blog.csdn.net/chengyuqiang/article/details/78837712 简单。
 *
 * @author xiaofeng
 */
public class FieldAnalyzer {

  /**
   * IK 最大化分词
   * <p>
   * 会将文本做最细粒度的拆分
   */
  public static final String IK_MAX_WORD = "ik_max_word";

  /**
   * IK 智能分词
   * <p>
   * 会做最粗粒度的拆分
   */
  public static final String IK_SMART = "ik_smart";

}
