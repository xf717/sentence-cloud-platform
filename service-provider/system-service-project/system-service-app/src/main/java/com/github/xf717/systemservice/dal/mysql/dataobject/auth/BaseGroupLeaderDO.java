package com.github.xf717.systemservice.dal.mysql.dataobject.auth;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.xf717.mybatis.core.dataobject.BaseDO;
import com.github.xf717.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("base_group_leader")
public class BaseGroupLeaderDO extends BaseDO {

  /**
   *
   */
  private Long id;

  /**
   *
   */
  private Long groupId;

  /**
   *
   */
  private Long userId;

  /**
   *
   */
  private String description;

  /**
   *
   */
  private String updHost;

  /**
   * 是否删除:1 是  0 否  默认：0
   */
  private Integer isDeleted;


}
