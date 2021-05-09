package com.github.xf717.managementweb.controller.auth.vo;

import io.swagger.annotations.ApiModel;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * GroupUsersVO
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/06 15:24
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "GroupUsersVO", description = "GroupUsersVO")
public class GroupUsersVO {

  private List<BaseUserVO> members;
  private List<BaseUserVO> leaders;

}
