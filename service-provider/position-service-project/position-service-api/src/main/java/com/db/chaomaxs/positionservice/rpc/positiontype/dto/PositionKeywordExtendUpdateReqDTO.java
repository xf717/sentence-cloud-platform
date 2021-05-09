package com.db.chaomaxs.positionservice.rpc.positiontype.dto;

import java.util.Date;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 职务关键词-扩展信息表
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Data
@Accessors(chain = true)
public class PositionKeywordExtendUpdateReqDTO implements Serializable {


    	/**
	 * 系统id
	 */
		@NotEmpty(message = "系统id")
	private Long id;
    
    	/**
	 * 内容
	 */
	private String content;
    
    	/**
	 * 关键词ID
	 */
	private Long keywordId;
    
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
