package com.github.xf717.userservice.dal.mysql.dataobject.resume;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.xf717.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_教育经历表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_edu_experience")
public class UserEduExperienceDO extends DeletableDO {

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



}
