package com.github.xf717.userservice.rpc.resume.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_资格证书表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserCredentialUpdateReqDTO implements Serializable {


  private static final long serialVersionUID = -3678686011613361792L;
  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 用户id
   */
  private Long userResumeId;

  /**
   * 证书名称
   */
  private String name;

  /**
   * 获得开始时间
   */
  private Date startTime;

  /**
   * 获得证书结束时间
   */
  private Date endTime;

}
