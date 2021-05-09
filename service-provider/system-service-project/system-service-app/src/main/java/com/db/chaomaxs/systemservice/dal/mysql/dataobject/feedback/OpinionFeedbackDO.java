package com.db.chaomaxs.systemservice.dal.mysql.dataobject.feedback;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 意见反馈信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("opinion_feedback")
public class OpinionFeedbackDO extends DeletableDO {

  /**
   * 系统id
   */

  private Long id;

  /**
   * 反馈人
   */
  private Long feedbackBy;

  /**
   * 反馈人名称
   */

  private String feedbackName;

  /**
   * 反馈手机号码
   */
  private String mobile;

  /**
   * 反馈平台类型(1求职端小程序,2企业端小程序,3企业端PC,4微信)
   */
  private Integer releasePlatformType;

  /**
   * 反馈时间
   */
  private Date releaseTime;

  /**
   * 处理状态(0待处理,1处理中,3已处理)
   */
  private Integer handleStatus;

  /**
   * 反馈内容
   */
  private String feedbackContent;

  /**
   * 内容
   */
  private String content;


}
