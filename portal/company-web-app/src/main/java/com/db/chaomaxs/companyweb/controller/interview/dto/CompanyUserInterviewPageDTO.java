package com.db.chaomaxs.companyweb.controller.interview.dto;
import com.db.chaomaxs.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 企业面试表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "CompanyUserInterviewPageDTO", description = "分页:企业面试表")
public class CompanyUserInterviewPageDTO extends PageParam {

  private static final long serialVersionUID = 9147842281228630959L;
  /**
   * 状态 0 -  待接受面试 1 -  待面试 2 -  拒绝面试 3 - 通过面试 4 - 拒绝录用 5-  接受录用 6 - 已取消
   */
  @ApiModelProperty(name = "status", value = "状态 0-待接受面试  1-待面试 2-拒绝面试3-通过面试4-拒绝录用 5-接受录用  6-已取消")
  private Integer status;
}
