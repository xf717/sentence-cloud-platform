package com.github.xf717.systemservice.rpc.dict.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 字典分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Data
@Accessors(chain = true)
public class DataDictionaryTypeRespDTO implements Serializable {

  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 字典类型名称
   */
  private String dictName;

  /**
   * 字典类型编号
   */
  private String dictCode;

  /**
   * 排序
   */
  private Integer sort;

  /**
   * 启用状态(1 启用 0不启用)
   */
  private Integer enabled;




}
