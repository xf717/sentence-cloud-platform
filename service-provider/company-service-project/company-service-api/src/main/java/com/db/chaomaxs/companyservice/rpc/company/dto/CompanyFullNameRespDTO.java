package com.db.chaomaxs.companyservice.rpc.company.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @author wst
 * @date 2021/5/8 10:07
 */

@Data
@Accessors(chain = true)
public class CompanyFullNameRespDTO implements Serializable {

  private static final long serialVersionUID = 4113031108774561811L;
  /**
   * 公司id
   */
  private Long id;

  /**
   * 公司全称
   */
  private String fullName;

}
