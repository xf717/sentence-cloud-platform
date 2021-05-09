package com.db.chaomaxs.companyservice.dal.mysql.dataobject.company;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 公司_相册
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("company_photo")
public class CompanyPhotoDO extends DeletableDO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 企业公司id
   */
  private Long companyId;

  /**
   * 相片存储地址
   */
  private String photoUrl;

}
