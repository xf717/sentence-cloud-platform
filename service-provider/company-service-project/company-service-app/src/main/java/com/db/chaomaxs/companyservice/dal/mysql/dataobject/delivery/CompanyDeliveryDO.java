package com.db.chaomaxs.companyservice.dal.mysql.dataobject.delivery;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 企业投递表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("company_delivery")
public class CompanyDeliveryDO extends BaseDO {

  /**
   * 主键id
   */
  private Long id;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 企业用户id
   */
  private Long companyUserId;

  /**
   * 职位id
   */
  private Long positionId;

  /**
   * 状态
   */
  private Integer status;

  /**
   * 是否删除
   */
  @TableLogic
  private Integer isDeleted;
}
