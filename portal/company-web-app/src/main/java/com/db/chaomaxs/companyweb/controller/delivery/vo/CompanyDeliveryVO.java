package com.db.chaomaxs.companyweb.controller.delivery.vo;

import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagRespDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业投递表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyDeliveryVO", description = "企业投递表")
public class CompanyDeliveryVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 用户id
   */
  @ApiModelProperty(name = "userId", value = "用户id")
  private Long userId;

  /**
   * 头像
   */
	@ApiModelProperty(name = "avatarUrl", value = "头像")
  private String avatarUrl;

  /**
   * 用户名称
   */
	@ApiModelProperty(name = "realName", value = "用户名称")
  private String realName;

  /**
   * 年龄
   */
	@ApiModelProperty(name = "age", value = "年龄")
  private Integer age;

  /**
   * 学历
   */
	@ApiModelProperty(name = "education", value = "学历")
  private Long education;

  /**
   * 工作年限
   */
	@ApiModelProperty(name = "workYearTotal", value = "工作年限")
  private Integer workYearTotal;

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
   * 公司名称
   */
	@ApiModelProperty(name = "companyName", value = "公司名称")
  private String companyName;


  /**
   * 职位名称
   */
	@ApiModelProperty(name = "positionName", value = "职位名称")
  private String positionName;


  /**
   * 上家公司工作时间
   */
	@ApiModelProperty(name = "lastCompanyWorkYear", value = "上家公司工作时间")
  private String lastCompanyWorkYear;

  /**
   * 工作经历标签
   */
	@ApiModelProperty(name = "status", value = "状态")
  private List<UserWorkSkillTagRespDTO> workSkillTagList;

  /**
   * 自我评价
   */
	@ApiModelProperty(name = "evaluate", value = "自我评价")
  private String evaluate;


}
