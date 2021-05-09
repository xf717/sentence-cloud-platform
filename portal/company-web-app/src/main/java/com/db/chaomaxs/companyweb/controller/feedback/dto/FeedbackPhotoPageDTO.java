package com.db.chaomaxs.companyweb.controller.feedback.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 帮助与反馈_图片说明
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "FeedbackPhotoPageDTO", description = "分页:帮助与反馈_图片说明")
public class FeedbackPhotoPageDTO extends PageParam {

  private static final long serialVersionUID = -5846285602601025518L;
  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 帮助与反馈id
   */
  @ApiModelProperty(name = "feedbackId", value = "帮助与反馈id")
  private Long feedbackId;

  /**
   * 相片资源id 关联资源库表id
   */
  @ApiModelProperty(name = "imageResourceId", value = "相片资源id 关联资源库表id")
  private Long imageResourceId;

  /**
   * 是否删除:1 是  0 否  默认：0
   */
  @ApiModelProperty(name = "isDeleted", value = "是否删除:1 是  0 否  默认：0")
  private Integer isDeleted;

  /**
   * 创建时间
   */
  @ApiModelProperty(name = "createTime", value = "创建时间")
  private Date createTime;

  /**
   * 创建人
   */
  @ApiModelProperty(name = "createBy", value = "创建人")
  private Long createBy;

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
