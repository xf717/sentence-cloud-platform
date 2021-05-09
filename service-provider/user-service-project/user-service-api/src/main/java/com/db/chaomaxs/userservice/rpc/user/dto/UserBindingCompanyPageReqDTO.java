package com.db.chaomaxs.userservice.rpc.user.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_企业绑定
 *
 * @author hlf
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserBindingCompanyPageReqDTO extends PageParam implements Serializable {

  /**
   * 公司id
   */
  private Long companyId;

  /**
   * 绑定状态， 0-未绑定，1-已绑定，2-已解绑， 3-已拒绝
   */
  private Integer bindingState;

}
