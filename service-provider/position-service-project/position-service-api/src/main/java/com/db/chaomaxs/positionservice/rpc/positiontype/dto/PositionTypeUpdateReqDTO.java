package com.db.chaomaxs.positionservice.rpc.positiontype.dto;

import java.util.Date;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 职务职位分类信息表
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Data
@Accessors(chain = true)
public class PositionTypeUpdateReqDTO implements Serializable {


    	/**
	 * 系统id
	 */
		@NotEmpty(message = "系统id")
	private Long id;
    
    	/**
	 * 分类名称
	 */
	private String typeName;
    
    	/**
	 * 编号  1-2-3
	 */
	private String code;
    
    	/**
	 * 级别
	 */
	private Integer level;
    
    	/**
	 * 上级分类ID
	 */
	private Long parentId;
    
    	/**
	 * 显示状态（1显示 0不显示）
	 */
	private Integer displayStatus;
    
    	/**
	 * 排序
	 */
	private Integer sortOrder;
    
    	/**
	 * 是否删除 1:是 0否  默认：0
	 */
	private Integer isDeleted;
    
    	/**
	 * 创建时间
	 */
	private Date createTime;
    
    	/**
	 * 创建人
	 */
	private Long createBy;
    
    	/**
	 * 修改时间
	 */
	private Date updateTime;
    
    	/**
	 * 修改人
	 */
	private Long updateBy;
    

}
