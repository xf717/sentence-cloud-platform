package com.github.xf717.managementweb.controller.auth.dto;

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
@ApiModel(value = "BaseElementUpdateDTO", description = "更新")
public class BaseElementUpdateDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * id
   */
  @ApiModelProperty(name = "id", value = "id")
  @NotNull(message = "更新对象id")
  @Min(value = 1, message = "默认最小值")
  private Long id;

  /**
   * 资源编码
   */
  @ApiModelProperty(name = "code", value = "资源编码")
  @NotNull(message = "资源编码为空")
  private String code;

  /**
   * 资源类型
   */
  @ApiModelProperty(name = "type", value = "资源类型")
  @NotNull(message = "资源类型不能为空")
  private String type;

  /**
   * 资源名称
   */
  @ApiModelProperty(name = "name", value = "资源名称")
  @NotNull(message = "资源名称不能为空")
  private String name;

  /**
   * 资源路径
   */
  @ApiModelProperty(name = "uri", value = "资源路径")
  @NotNull(message = "资源uri不能为空")
  private String uri;

  /**
   * 资源关联菜单
   */
  @ApiModelProperty(name = "menuId", value = "资源关联菜单")
  private Long menuId;

  /**
   *
   */
  @ApiModelProperty(name = "parentId", value = "父id")
  @Min(value = 0, message = "默认最小值")
  private Long parentId;

  /**
   * 资源树状检索路径
   */
  @ApiModelProperty(name = "path", value = "资源树状检索路径")
  private String path;

  /**
   * 资源请求类型
   */
  @ApiModelProperty(name = "method", value = "资源请求类型")
  @NotNull(message = "方法不能为空")
  private String method;

  /**
   * 描述
   */
  @ApiModelProperty(name = "description", value = "描述")
  private String description;


}
