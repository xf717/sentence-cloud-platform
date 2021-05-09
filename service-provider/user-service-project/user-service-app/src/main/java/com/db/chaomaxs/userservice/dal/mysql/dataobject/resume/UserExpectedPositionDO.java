package com.db.chaomaxs.userservice.dal.mysql.dataobject.resume;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_期望职位
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_expected_position")
public class UserExpectedPositionDO extends DeletableDO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 用户简历id
   */
  private Long userResumeId;

  /**
   * 期望职位id
   */
  private Long positionTypeId;

  /**
   * 期望职位类型名称
   */
  private String positionTypeName;

  /**
   * 城市编码
   */
  private String cityCode;

  /**
   * 城市名称
   */
  private String cityName;

  /**
   * 渠道id
   */
  private BigDecimal longitude;

  /**
   * 纬度
   */
  private BigDecimal latitude;


  /**
   * 期望薪资(开始)
   */
  private Integer startSalary;

  /**
   * 期望薪资(结束)
   */
  private Integer endSalary;

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;



}
