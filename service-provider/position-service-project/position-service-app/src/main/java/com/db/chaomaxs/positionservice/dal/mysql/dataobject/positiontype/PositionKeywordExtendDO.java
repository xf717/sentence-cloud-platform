package com.db.chaomaxs.positionservice.dal.mysql.dataobject.positiontype;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;



/**
 * 职务关键词-扩展信息表
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("position_keyword_extend")
public class PositionKeywordExtendDO extends DeletableDO{

    	/**
	 * 系统id
	 */
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
