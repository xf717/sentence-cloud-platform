package com.db.chaomaxs.userservice.rpc.resume.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_项目经历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Data
@Accessors(chain = true)
public class UserProjectExperienceUpdateReqDTO implements Serializable {


  private static final long serialVersionUID = -5792167794805310975L;
  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 用户简历id,关联user_resume表id
   */
  private Long userResumeId;

  /**
   * 项目名称
   */
  private String projectName;

  /**
   * 项目开始时间
   */
  private Date startTime;

  /**
   * 项目结束时间
   */
  private Date endTime;

  /**
   * 项目描述
   */
  private String description;

}
