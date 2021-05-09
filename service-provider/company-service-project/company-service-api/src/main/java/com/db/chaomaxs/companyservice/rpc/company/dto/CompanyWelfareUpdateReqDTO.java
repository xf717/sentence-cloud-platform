package com.db.chaomaxs.companyservice.rpc.company.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 公司福利
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class CompanyWelfareUpdateReqDTO implements Serializable {

  private static final long serialVersionUID = 279475745332449536L;
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
   * 是否删除:1 是  0 否  默认：0
   */
  private Integer isDeleted;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 创建人
   */
  private Long createBy;

  /**
   * 修改时间
   */
  private Date updateTime;

  /**
   * 修改人
   */
  private Long updateBy;


}
