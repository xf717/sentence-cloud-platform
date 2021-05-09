package com.db.chaomaxs.managementweb.controller.content.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;



/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 行业分类信息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "IndustryTypePageDTO",description = "分页:行业分类信息表")
public class IndustryTypePageDTO extends PageParam {


  private static final long serialVersionUID = 2162644039635215181L;
}
