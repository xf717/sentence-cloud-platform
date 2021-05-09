package com.db.chaomaxs.companyservice.dal.mysql.dataobject.chat;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 企业我的沟通
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("company_user_chat")
public class CompanyUserChatDO extends BaseDO {

  /**
   * 主键id
   */
  private Long id;

  /**
   * 企业用户id
   */
  private Long companyUserId;


  /**
   * 用户id
   */
  private Long userId;

  /**
   * 职位id
   */
  private Long positionId;

  /**
   * 沟通状态:0-未沟通 1-已沟通  2-其它
   */
  private Integer status;

  /**
   * 排序
   */
  private Integer sort;

  /**
   * 是否删除
   */
  @TableLogic
  private Integer isDeleted;



}
