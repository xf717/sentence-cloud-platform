package com.db.chaomaxs.companyservice.rpc.interview.dto;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 企业面试表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class CompanyUserInterviewReqDTO implements Serializable {
  /**
   * 企业用户id
   */
  private Long companyUserId;

  /**
   * 企业用户id
   */
  private Long companyId;

  /**
   * 用户id
   */
  private Long userId;

}