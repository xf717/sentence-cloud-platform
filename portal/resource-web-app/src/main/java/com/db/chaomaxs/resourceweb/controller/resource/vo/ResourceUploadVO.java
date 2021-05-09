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
@ApiModel(value = "ResourceUploadVO", description = "文件资源上传信息")
public class ResourceUploadVO {

  /**
   * 资源id
   */
  @ApiModelProperty(name = "resourceId", value = "resourceId")
  private Long resourceId;


  /**
   * 文件地址
   */
  @ApiModelProperty(name = "fileUrl", value = "文件地址")
  private String fileUrl;


}
