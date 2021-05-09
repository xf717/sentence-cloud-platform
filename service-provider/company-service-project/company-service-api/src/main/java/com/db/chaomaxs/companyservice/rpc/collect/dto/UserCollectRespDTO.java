package com.db.chaomaxs.companyservice.rpc.collect.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


/**
 *
 *
 * @author momo
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class UserCollectRespDTO implements Serializable {

  /**
   * 主键id
   */
  @NotEmpty(message = "主键id")
  private Long id;

  /**
   * 企业用户id
   */
  private Long companyUserId;


  /**
   * 用户id
   */
  private Long positionId;




}
