package com.db.chaomaxs.userservice.dal.mysql.dataobject.resume;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_工作经历_技能标签信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_work_skill_tag")
public class UserWorkSkillTagDO extends DeletableDO {

  /**
   * 系统id
   */
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
