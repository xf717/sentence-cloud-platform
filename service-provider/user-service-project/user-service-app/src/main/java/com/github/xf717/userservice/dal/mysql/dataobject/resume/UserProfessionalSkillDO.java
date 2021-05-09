package com.github.xf717.userservice.dal.mysql.dataobject.resume;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.xf717.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_专业技能表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_professional_skill")
public class UserProfessionalSkillDO extends DeletableDO {

  /**
   * 用户消息id
   */
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

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;


}
