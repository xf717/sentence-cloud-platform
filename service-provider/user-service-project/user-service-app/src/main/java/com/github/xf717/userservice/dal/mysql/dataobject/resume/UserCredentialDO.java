package com.github.xf717.userservice.dal.mysql.dataobject.resume;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.xf717.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_资格证书表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_credential")
public class UserCredentialDO extends DeletableDO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 用户id
   */
  private Long userResumeId;

  /**
   * 权益id
   */
  private String name;

  /**
   * 获得开始时间
   */
  private Date startTime;

  /**
   * 获得证书结束时间
   */
  private Date endTime;

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;


}
