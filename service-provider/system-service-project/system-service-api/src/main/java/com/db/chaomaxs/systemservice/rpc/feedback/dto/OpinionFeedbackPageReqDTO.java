package com.db.chaomaxs.systemservice.rpc.feedback.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 意见反馈信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Data
@Accessors(chain = true)
public class OpinionFeedbackPageReqDTO extends PageParam implements Serializable {


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
   * 反馈开始时间
   */
  private Date releaseStartTime;

  /**
   * 反馈结束时间
   */
  private Date releaseEndTime;

  /**
   * 处理状态(0待处理,1处理中,3已处理)
   */
  private Integer handleStatus;


  /**
   * 编辑开始时间
   */
  private Date editStartTime;

  /**
   * 编辑结束时间
   */
  private Date editEndTime;

  /**
   * 反馈内容
   */
  private String feedbackContent;


}
