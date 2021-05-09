package com.db.chaomaxs.userservice.rpc.user.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 用户_屏蔽公司
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserHideCompanyCreateReqDTO implements Serializable {


  /**
   * 用户id
   */
  private Long userId;

  /**
   * 公司名称
   */
  private String companyName;

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;


}
