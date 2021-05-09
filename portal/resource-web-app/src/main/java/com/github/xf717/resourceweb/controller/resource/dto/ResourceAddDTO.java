package com.github.xf717.resourceweb.controller.resource.dto;

import com.github.xf717.common.framework.validator.InEnum;
import com.github.xf717.resourceservice.enums.resource.FileTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 文件资源表
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ResourceCreateDTO", description = "添加文件资源表")
public class ResourceAddDTO {

  /**
   * 文件名
   */
  @ApiModelProperty(name = "fileName", value = "文件名")
  private String fileName;

  /**
   * 文件类型 1 - 图片 2 - 文件 3-  简历
   */
  @ApiModelProperty(name = "fileType", value = "文件类型 1 - 图片  2 - 文件3-  简历")
  @InEnum(FileTypeEnum.class)
  private Integer fileType;

  /**
   * 文件大小，单位(Byte)
   */
  @ApiModelProperty(name = "fileSize", value = "文件大小")
  private Long fileSize;

  /**
   * 文件地址
   */
  @ApiModelProperty(name = "fileUrl", value = "文件地址")
  private String fileUrl;


}
