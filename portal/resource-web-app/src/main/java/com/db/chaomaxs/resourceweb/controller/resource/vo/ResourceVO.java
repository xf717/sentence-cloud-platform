package com.db.chaomaxs.resourceweb.controller.resource.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 文件资源表
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ResourceVO", description = "文件资源")
public class ResourceVO {

  /**
   *
   */
  @ApiModelProperty(name = "id", value = "")
  private Long id;

  /**
   * 文件名
   */
  @ApiModelProperty(name = "fileName", value = "文件名")
  private String fileName;

  /**
   * 文件大小，单位(Byte)
   */
  @ApiModelProperty(name = "fileSize", value = "文件大小，单位(Byte)")
  private Long fileSize;

  /**
   * 文件地址
   */
  @ApiModelProperty(name = "fileUrl", value = "文件地址")
  private String fileUrl;

  /**
   * 文件类型 1 - 图片 2 - 文件 3-  简历
   */
  @ApiModelProperty(name = "fileType", value = "文件类型 1 - 图片  2 - 文件3-  简历")
  private Integer fileType;

}
