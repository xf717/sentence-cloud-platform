package com.github.xf717.userweb.controller.resume.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_教育经历表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserEduExperienceDTO {

  /**
   * 系统id
   */
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

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;

  /**
   * 是否删除 1:是 0否  默认：0
   */
  private Integer isDeleted;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 创建人
   */
  private Long createBy;

  /**
   * 修改时间
   */
  private Date updateTime;

  /**
   * 修改人
   */
  private Long updateBy;


}
