package com.db.chaomaxs.userservice.rpc.resume.dto;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_期望职位
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserExpectedPositionUpdateReqDTO implements Serializable {


  private static final long serialVersionUID = 8489448807576926004L;
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
   * 期望行业
   */
  private List<UserExpectedPositionIndustryUpdateReqDTO> expectedPositionIndustryList;


}
