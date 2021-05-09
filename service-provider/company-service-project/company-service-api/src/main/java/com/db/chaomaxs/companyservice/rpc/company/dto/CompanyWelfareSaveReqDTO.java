package com.db.chaomaxs.companyservice.rpc.company.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 公司福利保存请求类
 *
 * @author hlf
 * @date 2021-04-26 15:12:33
 */
@Data
@Accessors(chain = true)
public class CompanyWelfareSaveReqDTO implements Serializable {

  private static final long serialVersionUID = 6943725760366749179L;

  /**
   * 主键id
   */
  @NotEmpty(message = "主键id")
  private Long id;

  /**
   * 父id
   */
  private Long parentId;

  /**
   * 福利类型：0.通用 1.自定义福利 默认：0
   */
  private Integer welfareType;

  /**
   * 是否选中
   */
  private Integer choose;

  /**
   * 福利名称
   */
  private String name;

  /**
   * 公司id
   */
  private Long companyId;

}
