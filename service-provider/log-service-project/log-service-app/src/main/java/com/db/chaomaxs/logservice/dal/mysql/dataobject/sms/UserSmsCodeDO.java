package com.db.chaomaxs.logservice.dal.mysql.dataobject.sms;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;


/**
 * 用户短信验证码表
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:02
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_sms_code")
public class UserSmsCodeDO extends DeletableDO {

  /**
   *
   */
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
  @TableField("is_used")
  private Integer used;

  /**
   * 使用时间
   */
  private Date usedTime;

  /**
   * 使用IP
   */
  private String usedIp;


}
