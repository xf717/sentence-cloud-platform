package com.github.xf717.userservice.rpc.resume.dto;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 用户_期望职位
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserExpectedPositionRespDTO implements Serializable {

  private static final long serialVersionUID = 7907621985621046947L;
  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 用户简历id
   */
  private Long userResumeId;

  /**
   * 期望职位id
   */
  private Long positionTypeId;

  /**
   * 期望职位类型名称
   */
  private String positionTypeName;


  /**
   * 城市编码
   */
  private String cityCode;

  /**
   * 城市名称
   */
  private String cityName;


  /**
   * 期望薪资(开始)
   */
  private Integer startSalary;

  /**
   * 期望薪资(结束)
   */
  private Integer endSalary;

  /**
   * 行业类型
   */
  private List<UserExpectedPositionIndustryRespDTO> expectedPositionIndustryList;


}
