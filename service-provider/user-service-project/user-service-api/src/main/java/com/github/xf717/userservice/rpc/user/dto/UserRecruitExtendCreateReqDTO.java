package com.github.xf717.userservice.rpc.user.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;


/**
 * 用户_招聘_扩展表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:54:37
 */
@Data
@Accessors(chain = true)
public class UserRecruitExtendCreateReqDTO implements Serializable {

  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 用户信息id
   */
  private Long userId;

  /**
   * 用户头像url
   */
  private String photoUrl;

  /**
   * 微信号
   */
  private String weixin;

  /**
   * 职务
   */
  private String position;

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;

  /**
   * 公司名称
   */
  private String companyName;

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
