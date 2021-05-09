package com.github.xf717.managementweb.controller.notice.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 通知信息表
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "NoticeInformationCreateDTO",description = "添加通知信息表")
public class NoticeInformationAddDTO {

    	/**
	 * 系统id
	 */
	@ApiModelProperty(name ="id",value = "系统id")
	private Long id;
    
    	/**
	 * 标题
	 */
	@ApiModelProperty(name ="title", value = "标题")
	private String title;
    
    	/**
	 * 定时发布时间
	 */
	@ApiModelProperty(name ="intervaLtime", value = "定时发布时间")
	private Date intervaLtime;
    
    	/**
	 * 发布时间
	 */
	@ApiModelProperty(name ="releaseTime", value = "发布时间")
	private Date releaseTime;
    
    	/**
	 * 发布类型:关联字典表id
	 */
	@ApiModelProperty(name ="releaseTypeDictionaryId", value = "发布类型:关联字典表id")
	private Long releaseTypeDictionaryId;
    
    	/**
	 * 消息URL
	 */
	@ApiModelProperty(name ="url", value = "消息URL")
	private String url;
    
    	/**
	 * 弹框结束时间
	 */
	@ApiModelProperty(name ="popupEndTime", value = "弹框结束时间")
	private Date popupEndTime;
    
    	/**
	 * 弹框开始时间
	 */
	@ApiModelProperty(name ="popupStartTime", value = "弹框开始时间")
	private Date popupStartTime;
    
    	/**
	 * 弹框图片ID
	 */
	@ApiModelProperty(name ="popupResourseId", value = "弹框图片ID")
	private Long popupResourseId;
    
    	/**
	 * 显示方式 关联字典表id
	 */
	@ApiModelProperty(name ="displayModeDictionaryId", value = "显示方式 关联字典表id")
	private Long displayModeDictionaryId;
    
    	/**
	 * 发布状态（0待发布,1 立即发布,2定时发布）
	 */
	@ApiModelProperty(name ="status", value = "发布状态（0待发布,1 立即发布,2定时发布）")
	private Integer status;
    
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
