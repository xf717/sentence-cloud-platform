package com.db.chaomaxs.userservice.rpc.user.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: 屏蔽公司
 * @author wst
 * @date 2021/4/15 15:45
 */
@Data
@Accessors(chain = true)
public class UserHideCompanyBatchInsertRespDTO implements Serializable {

  /**
   * 屏蔽公司集合
   */
  private List<UserHideCompanyCreateReqDTO> userHideCompanyList;

}
