package com.github.xf717.systemservice.dal.mysql.dataobject.feedback;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.xf717.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 意见反馈_图片
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("opinion_feedback_image")
public class OpinionFeedbackImageDO extends DeletableDO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 意见反馈ID
   */
  private Long opinionFeedbackId;

  /**
   * 图片资源ID
   */
  private Long imageResourseId;

}
