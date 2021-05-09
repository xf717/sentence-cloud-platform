package com.github.xf717.userservice.rpc.resume.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserWorkSkillTagRespDTO implements Serializable {

  private static final long serialVersionUID = -8186755704287672476L;
  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 工作经历ID
   */
  private Long workExperienceId;

  /**
   * 技能标签
   */
  private String skillTag;

}
