package com.db.chaomaxs.systemservice.rpc.auth.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Data
@Accessors(chain = true)
public class BaseUserPageReqDTO extends PageParam implements Serializable {

  /**
   *
   */
  @NotEmpty(message = "")
  private Long id;

  /**
   *
   */
  private String username;

  /**
   *
   */
  private String password;

  /**
   *
   */
  private String name;

  /**
   *
   */
  private String birthday;

  /**
   *
   */
  private String address;

  /**
   *
   */
  private String mobilePhone;

  /**
   *
   */
  private String telPhone;

  /**
   *
   */
  private String email;

  /**
   *
   */
  private String sex;

  /**
   *
   */
  private String type;

  /**
   *
   */
  private String status;

  /**
   *
   */
  private String description;

  /**
   *
   */
  private String crtHost;

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
