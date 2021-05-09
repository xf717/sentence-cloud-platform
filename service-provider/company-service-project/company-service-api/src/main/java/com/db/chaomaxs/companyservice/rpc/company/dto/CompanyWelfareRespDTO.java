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
public class CompanyWelfareRespDTO implements Serializable {

  private static final long serialVersionUID = 7464817318717017085L;
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
   * 是否选中
   */
  private Integer choose;

  /**
   * 父id
   */
  private Long parentId;

}
