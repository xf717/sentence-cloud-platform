package com.db.chaomaxs.userservice.rpc.resume.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 用户_教育经历表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserEduExperienceRespDTO implements Serializable {

  private static final long serialVersionUID = -2851038410267697816L;
  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 用户在线简历id：关联user_resume表主键ID
   */
  private Long userResumeId;

  /**
   * 学校id，学校字典主键id
   */
  private Long schoolId;

  /**
   * 学校
   */
  private String schoolName;

  /**
   * 学历ID，字典表主键ID
   */
  private Long educationDictionaryId;

  /**
   * 学历
   */
  private String education;

  /**
   * 专业表ID，从在线上获取的数据
   */
  private Long specialityId;

  /**
   * 专业
   */
  private String specialityName;

  /**
   * 在校开始时间
   */
  private Date startTime;

  /**
   * 在校结束时间
   */
  private Date endTime;

}
