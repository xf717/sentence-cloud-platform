package com.db.chaomaxs.logservice.rpc.sms.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 用户短信验证码表
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:02
 */
@Data
@Accessors(chain = true)
public class UserSmsCodeListQueryReqDTO implements Serializable {


  private static final long serialVersionUID = -2642255505321427254L;
  /**
   *
   */
  @NotEmpty(message = "")
  private Long id;

  /**
   * 手机号码
   */
  private String mobile;

  /**
   * 验证码
   */
  private String code;

  /**
   * 发送场景：1-求职端手机号登陆 2-求职端更换号码  3-企业端登录  4-企业端注册
   */
  private Integer scene;

  /**
   * 今日发送的第几条
   */
  private Integer todayIndex;

  /**
   * 创建IP
   */
  private String createIp;

  /**
   * 消息状态 ：0-未使用  1 -已使用  默认1
   */
  private Integer isUsed;

  /**
   * 使用时间
   */
  private Date usedTime;

  /**
   * 使用IP
   */
  private String usedIp;

  /**
   * 是否删除 0 - 否1 - 是 默认-0
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
