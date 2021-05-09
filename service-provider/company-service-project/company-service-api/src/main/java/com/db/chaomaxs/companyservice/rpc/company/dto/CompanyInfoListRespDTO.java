package com.db.chaomaxs.companyservice.rpc.company.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @description: CompanyInfoListRespDTO
 * @author wst
 * @date 2021/4/20 16:32
 */

@Data
@Accessors(chain = true)
public class CompanyInfoListRespDTO implements Serializable {

  private Long id;

  /**
   * 公司全称
   *
   */
  private String fullName;

  /**
   * 公司规模字典id
   */
  private Long scopeDictionaryId;

  /**
   * 公司规模
   */
  private  String scope;

  /**
   * 融资情况字典id
   */
  private Long developmentStageDictionaryId;

  /**
   * 融资情况
   */
  private String developmentStage;

}
