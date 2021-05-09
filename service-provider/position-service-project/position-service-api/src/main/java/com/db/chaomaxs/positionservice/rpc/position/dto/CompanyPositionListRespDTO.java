package com.db.chaomaxs.positionservice.rpc.position.dto;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 职位列表信息，用于公司详情页职位列表
 *
 * @author xiaofeng
 * @date 2021-05-07 15:22:58
 */
@Data
@Accessors(chain = true)
public class CompanyPositionListRespDTO implements Serializable {

  private static final long serialVersionUID = 6996527640390261835L;
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


  /**
   * 学历ID，字典表主键ID
   */
  private Long educationId;


  /**
   * 最低薪资
   */
  private Integer startSalary;

  /**
   * 最高薪资
   */
  private Integer endSalary;


  private String status;

  /**
   * 区
   */
  private String areaCode;

  /**
   * 商圈
   */
  private String businessDistrict;

  /**
   * 职位关键字
   */
  private List<CompanyPositionKeywordRespDTO> keywordList;


}
