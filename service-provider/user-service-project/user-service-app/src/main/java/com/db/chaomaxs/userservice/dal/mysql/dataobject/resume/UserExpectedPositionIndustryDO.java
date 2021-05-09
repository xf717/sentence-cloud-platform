package com.db.chaomaxs.userservice.dal.mysql.dataobject.resume;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_期望_职位_行业
 *
 * @author wst
 * @date 2021-04-12 13:47:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_expected_position_industry")
public class UserExpectedPositionIndustryDO extends DeletableDO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 期望职位id，关联期望职位表id
   */
  private Long expectedPositionId;

  /**
   * 期望行业id,关联行业字典表id
   */
  private Long industryId;

  /**
   * 期望行业名称,冗余字段
   */
  private String industryName;


}
