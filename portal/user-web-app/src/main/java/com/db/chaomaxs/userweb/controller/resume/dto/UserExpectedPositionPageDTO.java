package com.db.chaomaxs.userweb.controller.resume.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.db.chaomaxs.common.framework.vo.PageParam;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 用户_期望职位
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "UserExpectedPositionPageDTO", description = "分页:用户_期望职位")
public class UserExpectedPositionPageDTO extends PageParam {

  private static final long serialVersionUID = 1L;

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 用户简历id
   */
  @ApiModelProperty(name = "userResumeId", value = "用户简历id")
  private Long userResumeId;

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
   * 渠道id
   */
  @ApiModelProperty(name = "longitude", value = "渠道id")
  private BigDecimal longitude;

  /**
   * 纬度
   */
  @ApiModelProperty(name = "latitude", value = "纬度")
  private BigDecimal latitude;

  /**
   * 期望薪资(开始)
   */
  @ApiModelProperty(name = "startSalaryDictionaryId", value = "期望薪资(开始)")
  private Long startSalaryDictionaryId;

  /**
   * 期望薪资(结束)
   */
  @ApiModelProperty(name = "endSalaryDictionaryId", value = "期望薪资(结束)")
  private Long endSalaryDictionaryId;

  /**
   * 公司id,做为数据隔离
   */
  @ApiModelProperty(name = "companyId", value = "公司id,做为数据隔离")
  private Long companyId;

  /**
   * 是否删除 1:是 0否  默认：0
   */
  @ApiModelProperty(name = "isDeleted", value = "是否删除 1:是 0否  默认：0")
  private Integer isDeleted;

  /**
   * 创建时间
   */
  @ApiModelProperty(name = "createTime", value = "创建时间")
  private Date createTime;

  /**
   * 创建人
   */
  @ApiModelProperty(name = "createBy", value = "创建人")
  private Long createBy;

  /**
   * 修改时间
   */
  @ApiModelProperty(name = "updateTime", value = "修改时间")
  private Date updateTime;

  /**
   * 修改人
   */
  @ApiModelProperty(name = "updateBy", value = "修改人")
  private Long updateBy;


}
