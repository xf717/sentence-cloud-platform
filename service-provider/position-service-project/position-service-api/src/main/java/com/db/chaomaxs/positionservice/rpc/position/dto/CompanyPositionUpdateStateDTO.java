package com.db.chaomaxs.positionservice.rpc.position.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业_职位状态修改
 *
 * @author hlf
 * @date 2021-04-20 09:45:08
 */
@Data
@Accessors(chain = true)
public class CompanyPositionUpdateStateDTO implements Serializable {

  private static final long serialVersionUID = -3710205554194830295L;

  /**
   * 企业用户id
   */
  private Long companyUserId;

  /**
   * 发布状态：0：待审核 1、 已通过 2、已拒绝 3、关闭
   */
  private Integer status;


}
