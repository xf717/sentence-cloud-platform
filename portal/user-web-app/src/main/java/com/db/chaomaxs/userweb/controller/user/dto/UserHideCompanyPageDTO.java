package com.db.chaomaxs.userweb.controller.user.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 用户_屏蔽公司
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "UserHideCompanyPageDTO", description = "分页:用户_屏蔽公司")
public class UserHideCompanyPageDTO extends PageParam {

  private static final long serialVersionUID = 1L;

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 用户简历id,关联user_resume表id
   */
  @ApiModelProperty(name = "userId", value = "用户简历id,关联user_resume表id")
  private Long userId;

  /**
   * 项目名称
   */
  @ApiModelProperty(name = "companyName", value = "项目名称")
  private String companyName;

  /**
   * 公司id,做为数据隔离
   */
  @ApiModelProperty(name = "companyId", value = "公司id,做为数据隔离")
  private Long companyId;

}
