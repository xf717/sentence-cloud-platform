package com.db.chaomaxs.managementweb.controller.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "BaseMenuUpdateDTO", description = "更新")
public class BaseMenuUpdateDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 主键id
   */
  @ApiModelProperty(name = "id", value = "主键id")
  private Long id;

  /**
   * 路径编码
   */
  @ApiModelProperty(name = "code", value = "路径编码", required = true, example = "userManager")
  @NotNull(message = "路径编码不能为空")
  private String code;

  /**
   * 标题
   */
  @ApiModelProperty(name = "title", value = "标题", required = true, example = "用户管理")
  @NotNull(message = "标题不能为空")
  private String title;

  /**
   * 父级节点
   */
  @ApiModelProperty(name = "parentId", value = "父级节点", required = true, example = "0")
  @Min(value = 0, message = "最小值为0")
  private Long parentId;

  /**
   * 资源路径
   */
  @ApiModelProperty(name = "href", value = "资源路径", required = true, example = "/admin/user")
  @NotNull(message = "资源路径不能为空")
  private String href;

  /**
   * 图标
   */
  @ApiModelProperty(name = "icon", value = "图标", required = true, example = "list-ul")
  @NotNull(message = "icon不能为空")
  private String icon;

  /**
   *
   */
  @ApiModelProperty(name = "type", value = "类型", required = true, example = "menu或dirt")
  @NotNull(message = "type不能为空")
  private String type;

  /**
   * 排序
   */
  @ApiModelProperty(name = "orderNum", value = "排序", example = "1")
  @NotNull(message = "排序")
  @Min(value = 0, message = "最小值为0")
  private Integer orderNum;

  /**
   * 描述
   */
  @ApiModelProperty(name = "description", value = "描述")
  private String description;

  /**
   * 菜单上下级关系
   */
  @ApiModelProperty(name = "path", value = "菜单上下级关系", required = true, example = "/adminSys/baseManager/userManager")
  @NotNull(message = "菜单上下级关系")
  private String path;

  /**
   * 前端组件路径
   */
  @ApiModelProperty(name = "componentPath", value = "前端组件路径", example = "pages/admin/user/index")
  private String componentPath;

  /**
   * 前端组件
   */
  @ApiModelProperty(name = "component", value = "前端组件", example = "userManager")
  private String component;


}
