package com.github.xf717.systemservice.rpc.content.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 行业分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@Accessors(chain = true)
public class IndustryTypeCreateReqDTO implements Serializable {


  /**
   * 系统id
   */
  private Long id;
  /**
   * 分类名称
   */
  private String typeName;

  /**
   * 编号
   */
  private String code;

  /**
   * 级别
   */
  private Integer level;

  /**
   * 上级分类ID
   */
  private Long parentId;

  /**
   * 显示状态(1显示 0不显示)
   */
  private Integer displayStatus;

  /**
   * 排序
   */
  private Integer sort;


}
