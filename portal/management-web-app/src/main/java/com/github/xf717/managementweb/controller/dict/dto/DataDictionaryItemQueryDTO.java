package com.github.xf717.managementweb.controller.dict.dto;

import io.swagger.annotations.ApiModel;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 数据字典项信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "DataDictionaryItemQueryDTO", description = "查询数据字典项信息表")
public class DataDictionaryItemQueryDTO {
  @NotEmpty
  private List<String> codes;


}
