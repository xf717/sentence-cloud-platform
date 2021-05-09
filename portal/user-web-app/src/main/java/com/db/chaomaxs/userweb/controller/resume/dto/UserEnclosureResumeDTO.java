package com.db.chaomaxs.userweb.controller.resume.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_附件_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserEnclosureResumeDTO {

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
