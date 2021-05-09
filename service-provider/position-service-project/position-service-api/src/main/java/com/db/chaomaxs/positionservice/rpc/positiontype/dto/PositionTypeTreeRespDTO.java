package com.db.chaomaxs.positionservice.rpc.positiontype.dto;

import com.db.chaomaxs.common.framework.vo.TreeNode;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 职务职位分类信息表
 *
 * @author ding
 * @date 2021-04-12
 */
@Data
@Accessors(chain = true)
public class PositionTypeTreeRespDTO extends TreeNode implements Serializable {


  /**
   * 分类名称
   */
  private String typeName;


}
