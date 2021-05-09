package com.db.chaomaxs.managementweb.controller.dict.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 字典分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "DataDictionaryTypePageDTO", description = "分页:字典分类信息表")
public class DataDictionaryTypePageDTO extends PageParam {

  private static final long serialVersionUID = -8056380042072839886L;
  /**
   * 查询关键字
   */
  @ApiModelProperty(name = "key", value = "查询关键字")
  private String key;

}
