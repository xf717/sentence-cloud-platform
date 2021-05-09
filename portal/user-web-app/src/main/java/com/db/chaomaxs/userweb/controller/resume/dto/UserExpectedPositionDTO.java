package com.db.chaomaxs.userweb.controller.resume.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_期望职位
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserExpectedPositionDTO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 用户简历id
   */
  private Long userResumeId;

  /**
   * 期望职位id
   */
  private Long positionTypeId;

  /**
   * 期望职位类型名称
   */
  private String positionTypeName;

  /**
   * 城市编码
   */
  private String cityCode;

  /**
   * 城市名称
   */
  private String cityName;

  /**
   * 渠道id
   */
  private BigDecimal longitude;

  /**
   * 纬度
   */
  private BigDecimal latitude;

  /**
   * 期望薪资(开始)
   */
  private Long startSalaryDictionaryId;

  /**
   * 期望薪资(结束)
   */
  private Long endSalaryDictionaryId;

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;

  /**
   * 是否删除 1:是 0否  默认：0
   */
  private Integer isDeleted;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 创建人
   */
  private Long createBy;

  /**
   * 修改时间
   */
  private Date updateTime;

  /**
   * 修改人
   */
  private Long updateBy;


}
