package com.db.chaomaxs.userservice.dal.mysql.dataobject.resume;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_resume")
public class UserResumeDO extends DeletableDO {

  /**
   * 主键Id
   */
  private Long id;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 出生年
   */
  private Integer birthdayYear;

  /**
   * 出身月
   */
  private Integer birthdayMonth;

  /**
   * 出生日
   */
  private Integer birthdayDay;

  /**
   * 参加工作时间
   */
  private Integer participateJob;

  /**
   * 工作年限
   */
  private Integer workYearTotal;

  /**
   * 自我评价
   */
  private String evaluate;

  /**
   * 求职状态:关键字典表id
   */
  private Long positionWantedDictionaryId;

  /**
   * 求职状态名称，冗余字段
   */
  private String positionWantedStatusName;

  /**
   *
   */
  private Integer isOpen;

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;


}
