package com.db.chaomaxs.userservice.rpc.resume.dto;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 用户_工作经历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserWorkExperienceRespDTO implements Serializable {

  private static final long serialVersionUID = 2172047536557190538L;
  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 用户简历id,关联user_resume 主键id
   */
  private Long userResumeId;

  /**
   * 公司名称
   */
  private String companyName;

  /**
   * 职位名称,冗余字段
   */
  private String positionName;


  /**
   * 入职时间
   */
  private Integer startJobTime;

  /**
   * 离职时间：-1值代表至今
   */
  private Integer quitJobTime;

  /**
   * 工作经历标签
   */
  private List<UserWorkSkillTagRespDTO> workSkillTagList;


  /**
   * 职位分类id：关键职位字典表id
   */
  private Long positionTypeId;

  /**
   * 职位分类名称
   */
  private String positionTypeName;

  /**
   * 所属行业id,关联行业字典表id
   */
  private Long industryId;

  /**
   * 所属行业名称,冗余字段
   */
  private String industryName;

  /**
   * 工作内容
   */
  private String content;

}
