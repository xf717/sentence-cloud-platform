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
@TableName("base_menu")
public class BaseMenuDO extends DeletableDO {

  /**
   *
   */
  private Long id;

  /**
   * 路径编码
   */
  private String code;

  /**
   * 标题
   */
  private String title;

  /**
   * 父级节点
   */
  private Long parentId;

  /**
   * 资源路径
   */
  private String href;

  /**
   * 图标
   */
  private String icon;

  /**
   *
   */
  private String type;

  /**
   * 排序
   */
  private Integer orderNum;

  /**
   * 描述
   */
  private String description;

  /**
   * 菜单上下级关系
   */
  private String path;

  /**
   * 启用禁用
   */
  private String enabled;

  /**
   * 组件
   */
  private String component;

  /**
   * 组件路径
   */
  private String componentPath;

  /**
   * 存储的JSON值
   */
  private String json;

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
