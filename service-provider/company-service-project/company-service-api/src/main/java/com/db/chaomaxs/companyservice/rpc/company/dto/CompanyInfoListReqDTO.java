package com.db.chaomaxs.companyservice.rpc.company.dto;

import java.io.Serializable;
import java.util.Set;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CompanyInfoListReqDTO implements Serializable {

  private static final long serialVersionUID = 7979103018818707851L;
  /**
   * 公司ids
   */
  private Set<Long> idsList;

}
