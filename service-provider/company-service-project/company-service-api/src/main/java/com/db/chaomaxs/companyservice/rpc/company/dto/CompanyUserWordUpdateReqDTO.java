package com.db.chaomaxs.companyservice.rpc.company.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业常用语表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class CompanyUserWordUpdateReqDTO implements Serializable {


  /**
   * 主键id
   */
  @NotEmpty(message = "主键id")
  private Long id;

  /**
   * 企业id
   */
  private Long companyId;

  /**
   * 企业用户id
   */
  private Long companyUserId;

  /**
   * 内容
   */
  private String content;

  /**
   * 排序
   */
  private Integer sort;

  /**
   * 是否删除 0 - 否 1-是
   */
  private Integer isDeleted;

  /**
   * 创建人
   */
  private Long createBy;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 修改人
   */
  private Long updateBy;

  /**
   * 修改时间
   */
  private Date updateTime;


}
