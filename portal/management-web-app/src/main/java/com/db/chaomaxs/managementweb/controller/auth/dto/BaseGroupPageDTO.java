package com.db.chaomaxs.managementweb.controller.auth.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "BaseGroupPageDTO", description = "分页:")
public class BaseGroupPageDTO extends PageParam {

  private static final long serialVersionUID = 418234316599519686L;
  /**
   *
   */
  @ApiModelProperty(name = "id", value = "")
  private Long id;

  /**
   * 角色编码
   */
  @ApiModelProperty(name = "code", value = "角色编码")
  private String code;

  /**
   * 角色名称
   */
  @ApiModelProperty(name = "name", value = "角色名称")
  private String name;

  /**
   * 上级节点
   */
  @ApiModelProperty(name = "parentId", value = "上级节点")
  private Long parentId;

  /**
   * 树状关系
   */
  @ApiModelProperty(name = "path", value = "树状关系")
  private String path;

  /**
   * 类型
   */
  @ApiModelProperty(name = "type", value = "类型")
  private String type;

  /**
   * 角色组类型
   */
  @ApiModelProperty(name = "groupType", value = "角色组类型")
  private Long groupType;

  /**
   *
   */
  @ApiModelProperty(name = "description", value = "")
  private String description;

  /**
   *
   */
  @ApiModelProperty(name = "crtHost", value = "")
  private String crtHost;

  /**
   * 是否删除:1 是  0 否  默认：0
   */
  @ApiModelProperty(name = "isDeleted", value = "是否删除:1 是  0 否  默认：0")
  private Integer isDeleted;

  /**
   * 创建时间
   */
  @ApiModelProperty(name = "createTime", value = "创建时间")
  private Date createTime;

  /**
   * 创建人
   */
  @ApiModelProperty(name = "createBy", value = "创建人")
  private Long createBy;

  /**
   * 修改时间
   */
  @ApiModelProperty(name = "updateTime", value = "修改时间")
  private Date updateTime;

  /**
   * 修改人
   */
  @ApiModelProperty(name = "updateBy", value = "修改人")
  private Long updateBy;


}
