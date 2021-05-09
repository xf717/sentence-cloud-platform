package com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
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
@TableName("base_group")
public class BaseGroupDO extends DeletableDO {

  /**
   *
   */
  private Long id;

  /**
   * 角色编码
   */
  private String code;

  /**
   * 角色名称
   */
  private String name;

  /**
   * 上级节点
   */
  private Long parentId;

  /**
   * 树状关系
   */
  private String path;

  /**
   * 类型
   */
  private String type;

  /**
   * 角色组类型
   */
  private Long groupType;

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
   * 创建时间
   */
  private Date createTime;

  /**
   * 创建人
   */
  private Long createBy;

  /**
   * 修改时间
   */
  private Date updateTime;

  /**
   * 修改人
   */
  private Long updateBy;


}
