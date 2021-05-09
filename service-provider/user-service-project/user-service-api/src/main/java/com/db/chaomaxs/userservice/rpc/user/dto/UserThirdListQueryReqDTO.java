package com.db.chaomaxs.userservice.rpc.user.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 用户_第三方表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
public class UserThirdListQueryReqDTO implements Serializable {


  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 账号id
   */
  private Long userId;

  /**
   * 第三方类型:1.微信，2：支付宝，3：钉钉，4.其它
   */
  private Integer thirdType;

  /**
   * 第三方标识
   */
  private String thirdIden;

  /**
   * 昵称,冗余字段
   */
  private String nickname;

  /**
   * 头像,冗余字段
   */
  private String avatarUrl;

  /**
   * 性别(1男、2女、0未知),冗余字段
   */
  private Integer gender;

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;

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
