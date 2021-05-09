package com.db.chaomaxs.companyservice.rpc.company.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
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
public class GreetContentUpdateReqDTO implements Serializable {


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
   * 打招呼语id,关联打招呼语字典表id
   */
  private Long greetId;

  /**
   * 打招呼语内容,关联打招呼语字典表字段，冗余字段
   */
  private String content;


}
