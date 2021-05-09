package com.db.chaomaxs.companyweb.controller.position.dto;

import com.db.chaomaxs.common.framework.util.base.annotation.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 职务职位分类信息表
 *
 * @author ding
 * @date 2021-04-06 17:45:09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "PositionTypeCreateDTO", description = "添加职务职位分类信息表")
public class PositionTypeAddDTO {


  /**
   * 分类名称
   */
  @NotNull
  @ApiModelProperty(name = "typeName", value = "分类名称")
	@Size(max = 25,message = "分类名称太长")
  private String typeName;


  /**
   * 上级分类ID
   */
  @ApiModelProperty(name = "parentId", value = "上级分类ID")
  private Long parentId;

  /**
   * 显示状态（1显示 0不显示）
   */
  @NotNull
  @ApiModelProperty(name = "displayStatus", value = "显示状态（1显示 0不显示）")
  private Integer displayStatus;

  /**
   * 排序
   */
  @NotNull
  @ApiModelProperty(name = "sortOrder", value = "排序")
  private Integer sortOrder;


}
