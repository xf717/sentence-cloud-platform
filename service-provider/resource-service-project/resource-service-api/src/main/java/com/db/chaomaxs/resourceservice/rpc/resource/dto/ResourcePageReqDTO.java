package com.db.chaomaxs.resourceservice.rpc.resource.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 文件资源表
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@Data
@Accessors(chain = true)
public class ResourcePageReqDTO extends PageParam {

  private static final long serialVersionUID = 3672734429207520054L;
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
