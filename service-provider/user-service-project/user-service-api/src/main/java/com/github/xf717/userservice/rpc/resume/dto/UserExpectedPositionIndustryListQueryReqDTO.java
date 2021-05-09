package com.github.xf717.userservice.rpc.resume.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 用户_期望_职位_行业
 *
 * @author wst
 * @date 2021-04-12 13:47:08
 */
@Data
@Accessors(chain = true)
public class UserExpectedPositionIndustryListQueryReqDTO implements Serializable {


  private static final long serialVersionUID = -3134329197901036540L;
  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 期望职位id，关联期望职位表id
   */
  private Long expectedPositionId;

  /**
   * 期望行业id,关联行业字典表id
   */
  private Long industryId;

  /**
   * 期望行业名称,冗余字段
   */
  private String industryName;


}
