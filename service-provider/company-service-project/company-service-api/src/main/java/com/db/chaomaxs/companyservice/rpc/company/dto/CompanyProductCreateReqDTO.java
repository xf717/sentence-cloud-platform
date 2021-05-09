package com.db.chaomaxs.companyservice.rpc.company.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 公司_产品
 *
 * @author hlf
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class CompanyProductCreateReqDTO implements Serializable {

  private static final long serialVersionUID = 3313093345962864070L;

  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 企业公司id
   */
  private Long companyId;

  /**
   * 产品logo图片地址
   */
  private String logoUrl;

  /**
   * 产品名称
   */
  private String productName;

}
