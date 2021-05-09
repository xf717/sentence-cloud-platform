package com.github.xf717.userweb.controller.resume.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 用户_简历
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserResumeCreateDTO",description = "添加用户_简历")
public class UserResumeAddDTO {

    	/**
	 * 主键Id
	 */
	@ApiModelProperty(name ="id",value = "主键Id")
	private Long id;
    
    	/**
	 * 用户id
	 */
	@ApiModelProperty(name ="userId", value = "用户id")
	private Long userId;
    
    	/**
	 * 出生年
	 */
	@ApiModelProperty(name ="birthdayYear", value = "出生年")
	private Integer birthdayYear;
    
    	/**
	 * 出身月
	 */
	@ApiModelProperty(name ="birthdayMonth", value = "出身月")
	private Integer birthdayMonth;
    
    	/**
	 * 出生日
	 */
	@ApiModelProperty(name ="birthdayDay", value = "出生日")
	private Integer birthdayDay;
    
    	/**
	 * 参加工作时间
	 */
	@ApiModelProperty(name ="participateJob", value = "参加工作时间")
	private Integer participateJob;
    
    	/**
	 * 工作年限
	 */
	@ApiModelProperty(name ="workYearTotal", value = "工作年限")
	private Integer workYearTotal;
    
    	/**
	 * 自我评价
	 */
	@ApiModelProperty(name ="evaluate", value = "自我评价")
	private String evaluate;
    
    	/**
	 * 求职状态:关键字典表id
	 */
	@ApiModelProperty(name ="positionWantedDictionaryId", value = "求职状态:关键字典表id")
	private Long positionWantedDictionaryId;
    
    	/**
	 * 求职状态名称，冗余字段
	 */
	@ApiModelProperty(name ="positionWantedStatusName", value = "求职状态名称，冗余字段")
	private String positionWantedStatusName;
    
    	/**
	 * 
	 */
	@ApiModelProperty(name ="isOpen", value = "")
	private Integer isOpen;
    
    	/**
	 * 公司id,做为数据隔离
	 */
	@ApiModelProperty(name ="companyId", value = "公司id,做为数据隔离")
	private Long companyId;
    
    	/**
	 * 是否删除 1:是 0否  默认：0
	 */
	@ApiModelProperty(name ="isDeleted", value = "是否删除 1:是 0否  默认：0")
	private Integer isDeleted;
    
    	/**
	 * 创建时间
	 */
	@ApiModelProperty(name ="createTime", value = "创建时间")
	private Date createTime;
    
    	/**
	 * 创建人
	 */
	@ApiModelProperty(name ="createBy", value = "创建人")
	private Long createBy;
    
    	/**
	 * 修改时间
	 */
	@ApiModelProperty(name ="updateTime", value = "修改时间")
	private Date updateTime;
    
    	/**
	 * 修改人
	 */
	@ApiModelProperty(name ="updateBy", value = "修改人")
	private Long updateBy;
    

}
