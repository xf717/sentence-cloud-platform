package com.db.chaomaxs.resourceservice.rpc.resource.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
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
public class ResourceUpdateReqDTO implements Serializable {


  private static final long serialVersionUID = 3072800967155607036L;
  /**
   *
   */
  @NotEmpty(message = "")
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

  /**
   * 是否删除 0 - 否 1 - 是
   */
  private Integer isDeleted;

  /**
   * 创建人
   */
  private Long createBy;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 修改时间
   */
  private Date updateTime;

  /**
   * 修改人
   */
  private Long updateBy;


}
