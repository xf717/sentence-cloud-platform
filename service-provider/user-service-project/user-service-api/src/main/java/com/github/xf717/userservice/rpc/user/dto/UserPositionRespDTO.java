package com.github.xf717.userservice.rpc.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


/**
 *
 *  收藏、足迹返回字段类型一致
 * @author momo
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
public class UserPositionRespDTO implements Serializable {

  /**
   * 主键id
   */
  @NotEmpty(message = "主键id")
  private Long id;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 用户发布的职位id
   */
  private Long positionId;


  /**
   * 企业用户id
   */
  private Long companyUserId;


}
