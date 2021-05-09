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
@TableName("base_resource_authority")
public class BaseResourceAuthorityDO extends BaseDO {

  /**
   *
   */
  private Long id;

  /**
   * 角色ID
   */
  private Long authorityId;

  /**
   * 角色类型
   */
  private String authorityType;

  /**
   * 资源ID
   */
  private Long resourceId;

  /**
   * 资源类型
   */
  private String resourceType;

  /**
   *
   */
  private Long parentId;

  /**
   *
   */
  private String path;

  /**
   *
   */
  private String description;

  /**
   *
   */
  private String crtHost;

  /**
   * 是否删除:1 是  0 否  默认：0
   */
  private Integer isDeleted;
  
  /**
   * 修改时间
   */
  private Date updateTime;

  /**
   * 修改人
   */
  private Long updateBy;


}
