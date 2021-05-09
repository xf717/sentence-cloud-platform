package com.db.chaomaxs.companyweb.controller.position.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 企业_职位
 * @author momo
 * @date 2021-04-14 17:16:58
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyPositionKeywordUpdateDTO",description = "更新企业_职位")
public class CompanyPositionKeywordUpdateDTO {

    	/**
	 * 系统id
	 */
	@ApiModelProperty(name ="id",value = "系统id")
	private Long id;
    
    	/**
	 * 职位关键字id
	 */
	@ApiModelProperty(name ="positionKeywordId", value = "职位关键字id")
	private Long positionKeywordId;
    
    	/**
	 * 企业职位表id
	 */
	@ApiModelProperty(name ="companyPositionId", value = "企业职位表id")
	private Long companyPositionId;
    
    	/**
	 * 是否删除:1 是  0 否  默认：0
	 */
	@ApiModelProperty(name ="isDeleted", value = "是否删除:1 是  0 否  默认：0")
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
