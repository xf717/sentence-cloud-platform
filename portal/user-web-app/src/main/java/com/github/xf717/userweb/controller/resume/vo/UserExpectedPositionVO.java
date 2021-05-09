package com.github.xf717.userweb.controller.resume.vo;

import com.github.xf717.userweb.controller.resume.dto.UserExpectedPositionIndustryDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 *用户_期望职位
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserExpectedPositionVO",description = "用户_期望职位")
public class UserExpectedPositionVO{

    	/**
	 * 系统id
	 */
	@ApiModelProperty(name ="id", value = "系统id")
	private Long id;
    
    	/**
	 * 用户简历id
	 */
	@ApiModelProperty(name ="userResumeId" ,value = "用户简历id")
	private Long userResumeId;
    
    	/**
	 * 期望职位id
	 */
	@ApiModelProperty(name ="positionTypeId" ,value = "期望职位id")
	private Long positionTypeId;
    
    	/**
	 * 期望职位类型名称
	 */
	@ApiModelProperty(name ="positionTypeName" ,value = "期望职位类型名称")
	private String positionTypeName;

    
    	/**
	 * 城市编码
	 */
	@ApiModelProperty(name ="cityCode" ,value = "城市编码")
	private String cityCode;
    
    	/**
	 * 城市名称
	 */
	@ApiModelProperty(name ="cityName" ,value = "城市名称")
	private String cityName;

    	/**
	 * 期望薪资(开始)
	 */
	@ApiModelProperty(name ="startSalary" ,value = "期望薪资(开始)")
	private Integer startSalary;
    
    	/**
	 * 期望薪资(结束)
	 */
	@ApiModelProperty(name ="endSalary" ,value = "期望薪资(结束)")
	private Integer endSalary;

	/**
	 * 期望行业
	 */
	@ApiModelProperty(name = "expectedPositionIndustryList", value = "期望行业")
	private List<UserExpectedPositionIndustryDTO> expectedPositionIndustryList;

}
