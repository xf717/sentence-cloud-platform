package com.db.chaomaxs.userservice.rpc.resume.dto;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 用户_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Data
@Accessors(chain = true)
public class UserResumeRespDTO implements Serializable {

  private static final long serialVersionUID = -2418809327045882953L;
  /**
   * 主键Id
   */
  @NotEmpty(message = "主键Id")
  private Long id;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 出生年
   */
  private Integer birthdayYear;

  /**
   * 出身月
   */
  private Integer birthdayMonth;

  /**
   * 出生日
   */
  private Integer birthdayDay;

  /**
   * 参加工作时间
   */
  private Integer participateJob;

  /**
   * 工作年限
   */
  private Integer workYearTotal;

  /**
   * 自我评价
   */
  private String evaluate;

  /**
   * 求职状态:关键字典表id
   */
  private Long positionWantedDictionaryId;

  /**
   * 求职状态名称，冗余字段
   */
  private String positionWantedStatusName;

  /**
   * 学历
   */
  private String education;

  /**
   * 用户名称
   */
  private String username;

  /**
   * 年龄
   */
  private Integer age;

  /**
   * 头像
   */
  private String avatarUrl;

  /**
   * 用户_期望职位
   */
  private List<UserExpectedPositionRespDTO> userExpectedPositionList;
  /**
   * 用户_项目经历
   */
  private List<UserProjectExperienceRespDTO> userProjectExperienceList;
  /**
   * 用户_专业技能
   */
  private List<UserProfessionalSkillRespDTO> userProfessionalSkillList;
  /**
   * 用户_教育经历
   */
  private List<UserEduExperienceRespDTO> userEduExperienceList;
  /**
   * 用户_工作经历
   */
  private List<UserWorkExperienceRespDTO> userWorkExperienceList;
  /**
   * 用户_资格证书
   */
  private List<UserCredentialRespDTO> userCredentialList;


}
