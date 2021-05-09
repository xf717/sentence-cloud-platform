package com.db.chaomaxs.userweb.controller.resume.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 *用户_简历
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserResumeVO",description = "用户_简历")
public class UserResumeVO{

	/**
	 * 主键Id
	 */
	@ApiModelProperty(name = "id", value = "主键Id")
	private Long id;

	/**
	 * 用户名称
	 */
	@ApiModelProperty(name = "username", value = "用户名称")
	private String username;

	/**
	 * 年龄
	 */
	@ApiModelProperty(name = "age", value = "年龄")
	private Integer age;


	/**
	 * 工作年限
	 */
	@ApiModelProperty(name = "workYearTotal", value = "工作年限")
	private Integer workYearTotal;

	/**
	 * 自我评价
	 */
	@ApiModelProperty(name = "evaluate", value = "自我评价")
	private String evaluate;

	/**
	 * 头像
	 */
	@ApiModelProperty(name = "avatar", value = "头像")
	private String avatar;

	/**
	 * 学历
	 */
	@ApiModelProperty(name = "education", value = "学历")
	private String education;

	/**
	 * 求职状态:关键字典表id
	 */
	@ApiModelProperty(name ="positionWantedDictionaryId" ,value = "求职状态:关键字典表id")
	private Long positionWantedDictionaryId;

	/**
	 * 求职状态名称，冗余字段
	 */
	@ApiModelProperty(name ="positionWantedStatusName" ,value = "求职状态名称，冗余字段")
	private String positionWantedStatusName;


	/**
	 * 用户_期望职位
	 */
	@ApiModelProperty(name ="userExpectedPositionList" ,value = "用户_期望职位")
	private List<UserExpectedPositionVO> userExpectedPositionList;
	/**
	 * 用户_项目经历
	 */
	@ApiModelProperty(name ="userProjectExperienceList" ,value = "用户_项目经历")
	private List<UserProjectExperienceVO> userProjectExperienceList;
	/**
	 * 用户_专业技能
	 */
	@ApiModelProperty(name ="userProfessionalSkillList" ,value = "用户_专业技能")
	private List<UserProfessionalSkillVO> userProfessionalSkillList;
	/**
	 * 用户_教育经历
	 */
	@ApiModelProperty(name ="userEduExperienceList" ,value = "用户_教育经历")
	private List<UserEduExperienceVO> userEduExperienceList;
	/**
	 * 用户_工作经历
	 */
	@ApiModelProperty(name ="userWorkExperienceList" ,value = "用户_工作经历")
	private List<UserWorkExperienceVO> userWorkExperienceList;
	/**
	 * 用户_资格证书
	 */
	@ApiModelProperty(name ="userCredentialList" ,value = "用户_资格证书")
	private List<UserCredentialVO> userCredentialList;


}
