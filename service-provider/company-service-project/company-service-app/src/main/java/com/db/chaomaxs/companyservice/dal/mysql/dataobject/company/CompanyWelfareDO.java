package com.db.chaomaxs.companyservice.dal.mysql.dataobject.company;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 公司福利
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("company_welfare")
public class CompanyWelfareDO extends DeletableDO {

  /**
   * 系统id
   */
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
  @TableField("is_choose")
  private Integer choose;

  /**
   * 父id
   */
  private Long parentId;

}
