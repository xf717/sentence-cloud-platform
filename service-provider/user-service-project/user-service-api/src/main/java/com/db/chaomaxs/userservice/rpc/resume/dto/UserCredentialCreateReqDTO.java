package com.db.chaomaxs.userservice.rpc.resume.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 用户_资格证书表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserCredentialCreateReqDTO implements Serializable {


  private static final long serialVersionUID = 918966217919230955L;
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
