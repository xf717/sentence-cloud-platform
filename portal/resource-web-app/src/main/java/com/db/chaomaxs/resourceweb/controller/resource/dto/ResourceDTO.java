package com.db.chaomaxs.resourceweb.controller.resource.dto;

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
public class ResourceDTO {

  /**
   *
   */
  private Long id;

  /**
   * 文件名
   */
  private String fileName;

  /**
   * 文件大小，单位(Byte)
   */
  private Long fileSize;

  /**
   * 文件地址
   */
  private String fileUrl;

  /**
   * 文件类型 1 - 图片 2 - 文件 3-  简历
   */
  private Integer fileType;


}
