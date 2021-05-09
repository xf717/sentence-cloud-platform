package com.db.chaomaxs.resourceservice.dal.mysql.dataobject.resource;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 文件资源表
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("resource")
public class ResourceDO extends DeletableDO {

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
