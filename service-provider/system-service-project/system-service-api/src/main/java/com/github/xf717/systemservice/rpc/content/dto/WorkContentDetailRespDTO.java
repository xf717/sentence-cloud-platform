package com.github.xf717.systemservice.rpc.content.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wst
 * @date 2021/5/7 17:29
 */

@Data
@Accessors(chain = true)
public class WorkContentDetailRespDTO implements Serializable {

  private static final long serialVersionUID = 7115103590562839444L;

  /**
   * 职位分类三级ID  冗余字段
   */
  private Long threePositionTypeId;

  /**
   * 内容
   */
  private String content;
}
