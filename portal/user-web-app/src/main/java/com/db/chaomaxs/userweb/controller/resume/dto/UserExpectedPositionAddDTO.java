package com.db.chaomaxs.userweb.controller.resume.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserExpectedPositionCreateDTO", description = "添加用户_期望职位")
public class UserExpectedPositionAddDTO {

  /**
   * 期望职位id
   */
  @ApiModelProperty(name = "positionTypeId", value = "期望职位id")
  private Long positionTypeId;

  /**
   * 期望职位类型名称
   */
  @ApiModelProperty(name = "positionTypeName", value = "期望职位类型名称")
  private String positionTypeName;


  /**
   * 城市编码
   */
  @ApiModelProperty(name = "cityCode", value = "城市编码")
  private String cityCode;

  /**
   * 城市名称
   */
  @ApiModelProperty(name = "cityName", value = "城市名称")
  private String cityName;

  /**
   * 期望薪资(开始)
   */
  @ApiModelProperty(name = "startSalary", value = "期望薪资(开始)")
  private Integer startSalary;

  /**
   * 期望薪资(结束)
   */
  @ApiModelProperty(name = "endSalary", value = "期望薪资(结束)")
  private Integer endSalary;

  /**
   * 求职状态:关键字典表id
   */
  @ApiModelProperty(name = "positionWantedDictionaryId", value = "求职状态:关键字典表id")
  private Long positionWantedDictionaryId;

  /**
   * 求职状态名称，冗余字段
   */
  @ApiModelProperty(name = "positionWantedStatusName", value = "求职状态名称，冗余字段")
  private String positionWantedStatusName;

  @ApiModelProperty(name = "ExpectedPositionIndustryList", value = "期望行业")
  private List<UserExpectedPositionIndustryAddDTO> expectedPositionIndustryList;

}
