package com.db.chaomaxs.managementweb.controller.auth.vo;

import com.db.chaomaxs.common.framework.vo.TreeNode;
import io.swagger.annotations.ApiModel;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * AuthorityMenuTreeVO
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/02 20:09
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@ApiModel(value = "AuthorityMenuTreeVO", description = "AuthorityMenuTreeVO")
public class AuthorityMenuTreeVO extends TreeNode {

  private String text;
  private List<AuthorityMenuTreeVO> nodes;
  private String icon;

}
