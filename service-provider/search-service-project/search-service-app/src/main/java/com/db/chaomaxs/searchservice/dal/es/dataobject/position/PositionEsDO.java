package com.db.chaomaxs.searchservice.dal.es.dataobject.position;

import com.db.chaomaxs.searchservice.dal.es.FieldAnalyzer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author momo
 * @date 2021-04-22 17:54
 */

@Data
@Document(indexName = "position_index")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionEsDO {

  @Id
  private Long id;

  /**
   * 职位名称
   */
  @Field(type = FieldType.Text, store = true, analyzer = FieldAnalyzer.IK_MAX_WORD)
  private String positionName;


  /**
   * 职位类别名
   */
  @Field(type = FieldType.Long, store = true)
  private Long positionTypeId;


  /**
   * 经验要求：冗余字段
   */
  private String experience;

  /**
   * 学历ID，字典表主键ID
   */
  @Field(type = FieldType.Long, store = true)
  private Long educationId;

  /**
   * 学历
   */

  private String education;

  /**
   * 最低薪资
   */
  @Field(type = FieldType.Integer, store = true)
  private Integer startSalary;

  /**
   * 最高薪资
   */
  @Field(type = FieldType.Integer, store = true)
  private Integer endSalary;

  /**
   * 职位描述
   */
  private String content;

  /**
   * 省份
   */
  @Field(type = FieldType.Text, store = true)
  private String provinceCode;

  /**
   * 城市
   */
  @Field(type = FieldType.Text, store = true)
  private String cityCode;

  /**
   * 区
   */
  @Field(type = FieldType.Text, store = true)
  private String areaCode;
}
