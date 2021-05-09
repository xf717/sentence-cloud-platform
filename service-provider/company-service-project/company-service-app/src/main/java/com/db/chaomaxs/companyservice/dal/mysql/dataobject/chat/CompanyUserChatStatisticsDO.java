package com.db.chaomaxs.companyservice.dal.mysql.dataobject.chat;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 企业我的沟通
 *
 * @author momo
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@TableName("company_user_chat")
public class CompanyUserChatStatisticsDO{


  /**
   * 职位id
   */
  private Long positionId;

  /**
   * 总数
   */
  private Integer count;





}
