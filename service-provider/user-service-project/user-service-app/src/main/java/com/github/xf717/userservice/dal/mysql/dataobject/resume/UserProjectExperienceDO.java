package com.github.xf717.userservice.dal.mysql.dataobject.resume;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.xf717.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_项目经历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_project_experience")
public class UserProjectExperienceDO extends DeletableDO {

  /**
   * 系统id
   */
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

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;



}
