package com.db.chaomaxs.companyservice.dal.mysql.dataobject.settings;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 企业我的设置
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("company_user_set")
public class CompanyUserSetDO extends BaseDO {

  /**
   * 主键id
   */
  private Long id;

  /**
   * 企业用户id
   */
  private Long companyUserId;

  /**
   * 企业id
   */
  private Long companyId;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 是否拉入黑名单 0 - 否 1 - 是
   */
  private Integer blackSwitch;

  /**
   * 消息是否置顶 0 - 否 1 - 是
   */
  private Integer topSwitch;

  /**
   * 是否删除  0 - 否 1 - 是
   */
  @TableLogic
  private Integer isDeleted;


}
