package com.db.chaomaxs.userservice.rpc.resume.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_附件_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserEnclosureResumeUpdateReqDTO implements Serializable {


  private static final long serialVersionUID = -8915281318272540579L;
  /**
   * 主键Id
   */
  @NotEmpty(message = "主键Id")
  private Long id;


  /**
   * 附件资源ID
   */
  private Long resourceId;

  /**
   * 附件简历名称
   */
  private String resumeName;


}
