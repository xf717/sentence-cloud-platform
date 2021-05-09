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
@TableName("base_element")
public class BaseElementDO extends DeletableDO {

  /**
   *
   */
  private Long id;

  /**
   * 资源编码
   */
  private String code;

  /**
   * 资源类型
   */
  private String type;

  /**
   * 资源名称
   */
  private String name;

  /**
   * 资源路径
   */
  private String uri;

  /**
   * 资源关联菜单
   */
  private Long menuId;

  /**
   *
   */
  private Long parentId;

  /**
   * 资源树状检索路径
   */
  private String path;

  /**
   * 资源请求类型
   */
  private String method;

  /**
   * 描述
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
