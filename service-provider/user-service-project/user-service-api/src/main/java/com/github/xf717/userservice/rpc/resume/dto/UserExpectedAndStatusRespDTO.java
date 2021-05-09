package com.github.xf717.userservice.rpc.resume.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 用户_期望职位
 *
 * @author
 * @date
 */
@Data
@Accessors(chain = true)
public class UserExpectedAndStatusRespDTO implements Serializable {

  private static final long serialVersionUID = -8721001454449999689L;
  /**
   * 用户简历id
   */
  private Long userResumeId;

  /**
   * 求职状态:关键字典表id
   */
  private Long positionWantedDictionaryId;

  /**
   * 求职状态名称，冗余字段
   */
  private String positionWantedStatusName;

  /**
   * 用户求职期望职位
   */
  private List<UserExpectedPositionRespDTO> userExpectedPositionVOList;

}
