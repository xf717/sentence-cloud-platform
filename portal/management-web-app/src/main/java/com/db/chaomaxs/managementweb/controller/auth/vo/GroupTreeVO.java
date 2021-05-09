package com.db.chaomaxs.managementweb.controller.auth.vo;

import com.db.chaomaxs.common.framework.vo.TreeNode;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * GroupTreeVO
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/06 14:37
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@ApiModel(value = "GroupTreeVO", description = "GroupTreeVO")
public class GroupTreeVO extends TreeNode {

  private String label;

  private String name;


}
