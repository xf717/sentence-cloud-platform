package com.db.chaomaxs.companyservice.dal.mysql.dataobject.audit;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 公司_审核记录信息表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("company_audit_record")
public class CompanyAuditRecordDO extends DeletableDO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 审核人ID
   */
  private Long userId;

  /**
   * 审核人名称
   */
  private String userName;

  /**
   * 公司ID
   */
  private Long companyId;

  /**
   * 审核状态 0-未审核  1-已审核  2- 审核未通过
   */
  private Integer auditStatus;

  /**
   * 审核描述
   */
  private String description;

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
