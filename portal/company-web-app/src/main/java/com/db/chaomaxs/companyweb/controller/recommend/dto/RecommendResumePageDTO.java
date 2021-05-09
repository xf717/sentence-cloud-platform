package com.db.chaomaxs.companyweb.controller.recommend.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 推荐人才简历
 *
 * @author xiaofeng
 * @date 2021-03-29 17:09:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "RecommendResumePageDTO", description = "分页:推荐人才简历")
public class RecommendResumePageDTO extends PageParam {

  private static final long serialVersionUID = 7740291699027278139L;
  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 用户简历id
   */
  @ApiModelProperty(name = "userResumeId", value = "用户简历id")
  private Long userResumeId;

}
