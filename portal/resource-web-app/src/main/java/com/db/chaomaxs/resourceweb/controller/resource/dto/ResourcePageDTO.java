package com.db.chaomaxs.resourceweb.controller.resource.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 文件资源表
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "ResourcePageDTO", description = "分页:文件资源表")
public class ResourcePageDTO extends PageParam {

  private static final long serialVersionUID = -918666275726254783L;
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

  /**
   * 是否删除 0 - 否 1 - 是
   */
  @ApiModelProperty(name = "isDeleted", value = "是否删除 0 - 否 1 - 是")
  private Integer isDeleted;

  /**
   * 创建人
   */
  @ApiModelProperty(name = "createBy", value = "创建人")
  private Long createBy;

  /**
   * 创建时间
   */
  @ApiModelProperty(name = "createTime", value = "创建时间")
  private Date createTime;

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
