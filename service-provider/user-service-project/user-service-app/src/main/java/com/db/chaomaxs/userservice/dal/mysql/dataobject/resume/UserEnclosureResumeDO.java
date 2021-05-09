package com.db.chaomaxs.userservice.dal.mysql.dataobject.resume;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_附件_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_enclosure_resume")
public class UserEnclosureResumeDO extends DeletableDO {

  /**
   * 主键Id
   */
  private Long id;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 附件资源ID
   */
  private Long resourceId;

  /**
   * 是否删除 1:是 0否  默认：0
   */
  @TableLogic
  private Integer deleted;

  /**
   * 简历名称
   */
  private String resumeName;


}
