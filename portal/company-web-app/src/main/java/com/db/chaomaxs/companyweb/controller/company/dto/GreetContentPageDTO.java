package com.db.chaomaxs.companyweb.controller.company.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 打招呼语
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "GreetContentPageDTO", description = "分页:打招呼语")
public class GreetContentPageDTO extends PageParam {

  private static final long serialVersionUID = 1578302084075335631L;
  /**
   * 主键id
   */
  @ApiModelProperty(name = "id", value = "主键id")
  private Long id;

  /**
   * 用户id
   */
  @ApiModelProperty(name = "userId", value = "用户id")
  private Long userId;

  /**
   * 打招呼语id,关联打招呼语字典表id
   */
  @ApiModelProperty(name = "greetId", value = "打招呼语id,关联打招呼语字典表id")
  private Long greetId;

  /**
   * 打招呼语内容,关联打招呼语字典表字段，冗余字段
   */
  @ApiModelProperty(name = "content", value = "打招呼语内容,关联打招呼语字典表字段，冗余字段")
  private String content;

  /**
   * 是否删除 1:是 0否  默认：0
   */
  @ApiModelProperty(name = "isDeleted", value = "是否删除 1:是 0否  默认：0")
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
