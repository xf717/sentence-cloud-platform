package com.db.chaomaxs.companyservice.dal.mysql.dataobject.company;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 公司_产品
 *
 * @author hlf
 * @date 2021-03-26 10:18:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("company_product")
public class CompanyProductDO extends DeletableDO {

  /**
   * 系统id
   */
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
