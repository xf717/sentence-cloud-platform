package com.db.chaomaxs.companyservice.rpc.company.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 公司福利
 *
 * @author hlf
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class CompanyWelfareCreateReqDTO implements Serializable {

  private static final long serialVersionUID = -2016471671113763L;

  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 福利名称
   */
  private String name;

  /**
   * 企业公司id
   */
  private Long companyId;

  /**
   * 图标url
   */
  private String iconUrl;

  /**
   * 福利类型：0.通用 1.自定义福利 默认：0
   */
  private Integer welfareType;

  /**
   * 是否选中，1是 0否 默认：0
   */
  private Integer choose;


}
