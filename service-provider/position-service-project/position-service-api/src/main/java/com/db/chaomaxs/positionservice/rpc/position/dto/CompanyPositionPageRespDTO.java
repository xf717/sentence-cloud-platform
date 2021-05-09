package com.db.chaomaxs.positionservice.rpc.position.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-14 17:16:58
 */
@Data
@Accessors(chain = true)
public class CompanyPositionPageRespDTO implements Serializable {

  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 职位名称
   */
  private String positionName;


  /**
   * 经验要求：关联经验要求表主键id
   */
  private Long experienceId;

  private String experience;


  /**
   * 学历ID，字典表主键ID
   */
  private Long educationId;

  private String education;


  /**
   * 最低薪资
   */
  private Integer startSalary;

  /**
   * 最高薪资
   */
  private Integer endSalary;
  /**
   * 市
   */
  private String cityCode;

  /**
   * 商圈
   */
  private String businessDistrict;

  /**
   * 状态
   */
  private String status;

  /**
   * 看过我总数
   */
  private Integer tractCount;

  /**
   * 沟通过总数
   */
  private Integer chatCount;


}
