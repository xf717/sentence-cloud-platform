package com.db.chaomaxs.systemservice.dal.mysql.dataobject.content;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;



/**
 * 内容管理-问题扩展信息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("problem_information_extend")
public class ProblemInformationExtendDO extends DeletableDO{

    	/**
	 * 系统id
	 */
	private Long id;
    
    	/**
	 * 内容
	 */
	private String content;
    
    	/**
	 * 问题信息ID
	 */
	private Long problemInfoId;
    
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
