package com.github.xf717.userservice.rpc.resume.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_专业技能表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserProfessionalSkillUpdateReqDTO implements Serializable {


  private static final long serialVersionUID = -2220621699213070282L;
  /**
   * 用户消息id
   */
  @NotEmpty(message = "用户消息id")
  private Long id;

  /**
   * 用户id
   */
  private Long userResumeId;

  /**
   * 阅读时长
   */
  private String skillName;

  /**
   * 读完多少本
   */
  private Integer durationNum;

  /**
   * 掌握程度，关联字典表id
   */
  private Long masteryDictionaryId;


}
