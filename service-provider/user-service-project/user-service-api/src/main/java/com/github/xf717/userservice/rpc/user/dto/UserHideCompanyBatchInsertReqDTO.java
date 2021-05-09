package com.github.xf717.userservice.rpc.user.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: 用户_屏蔽公司
 * @author wst
 * @date 2021/4/15 15:07
 */
@Data
@Accessors(chain = true)
public class UserHideCompanyBatchInsertReqDTO implements Serializable {

  private static final long serialVersionUID = -2263034856751913630L;
  /**
   * 屏蔽公司集合
   */
  private List<UserHideCompanyCreateReqDTO> hideCompanyList;

}
