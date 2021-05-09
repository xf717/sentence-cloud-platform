package com.github.xf717.userservice.rpc.resume.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_工作经历_技能标签信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserWorkSkillTagUpdateReqDTO implements Serializable {


  private static final long serialVersionUID = -8869398947427615648L;
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
