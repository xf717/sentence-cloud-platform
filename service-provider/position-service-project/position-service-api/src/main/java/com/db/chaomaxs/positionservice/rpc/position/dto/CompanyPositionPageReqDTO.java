package com.db.chaomaxs.positionservice.rpc.position.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-14 17:16:58
 */
@Data
@Accessors(chain = true)
public class CompanyPositionPageReqDTO extends PageParam implements Serializable {

  private static final long serialVersionUID = -1861005251633161807L;
  /**
   * 企业用户ID
   */
  private Long companyUserId;

  /**
   * 审核状态
   */
  private Integer status;
}
