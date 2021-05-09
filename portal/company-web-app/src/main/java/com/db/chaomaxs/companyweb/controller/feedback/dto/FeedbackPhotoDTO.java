package com.db.chaomaxs.companyweb.controller.feedback.dto;

import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 帮助与反馈_图片说明
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class FeedbackPhotoDTO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 帮助与反馈id
   */
  private Long feedbackId;

  /**
   * 相片资源id 关联资源库表id
   */
  private Long imageResourceId;

  /**
   * 是否删除:1 是  0 否  默认：0
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
