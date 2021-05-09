package com.db.chaomaxs.userservice.rpc.resume.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_期望_职位_行业
 *
 * @author wst
 * @date 2021-04-12 13:47:08
 */
@Data
@Accessors(chain = true)
public class UserExpectedPositionIndustryUpdateReqDTO implements Serializable {


  private static final long serialVersionUID = -3804924134342348702L;
  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 期望职位id，关联期望职位表id
   */
  private Long expectedPositionId;

  /**
   * 期望行业id,关联行业字典表id
   */
  private Long industryId;

  /**
   * 期望行业名称,冗余字段
   */
  private String industryName;


}
