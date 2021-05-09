package com.db.chaomaxs.companyweb.controller.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 打招呼语
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "GreetContentVO", description = "打招呼语")
public class GreetContentVO implements Serializable {

  private static final long serialVersionUID = 1L;

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

  @ApiModelProperty(name = "enabledGreet", value = "是否启用打招呼 1.启用  0:未启用 默认:1")
  private Integer isEnabledGreet;

  @ApiModelProperty(name = "dictionaryItemList", value = "打招呼字典集合")
  List<DictionaryItemVO> dictionaryItemList;


}
