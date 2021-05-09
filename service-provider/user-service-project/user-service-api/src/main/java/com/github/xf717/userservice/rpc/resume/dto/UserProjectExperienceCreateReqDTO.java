package com.github.xf717.userservice.rpc.resume.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 用户_项目经历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Data
@Accessors(chain = true)
public class UserProjectExperienceCreateReqDTO implements Serializable {


  private static final long serialVersionUID = -9177310725344414344L;
  /**
   * 用户简历id,关联user_resume表id
   */
  @NotEmpty(message = "简历id")
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
