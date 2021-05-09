package com.db.chaomaxs.companyservice.rpc.company.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author hlf
 * @version 1.0
 * @description: 公司福利信息返回类
 * @date 2021/4/27 14:43
 */
@Data
@Accessors(chain = true)
public class CompanyWelfareInfoRespDTO implements Serializable {

  /**
   * 福利类型list
   */
  private List<CompanyWelfareRespDTO> companyWelfareRespDTOs;

  /**
   * 选中数量
   */
  private Integer chooseNumber;
}
