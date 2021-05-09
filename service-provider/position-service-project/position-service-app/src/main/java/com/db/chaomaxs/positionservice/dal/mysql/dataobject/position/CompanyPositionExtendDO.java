package com.db.chaomaxs.positionservice.dal.mysql.dataobject.position;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;



/**
 * 企业职位_扩展信息表
 * @author momo
 * @date 2021-04-21 15:17:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("company_position_extend")
public class CompanyPositionExtendDO extends DeletableDO{

    	/**
	 * 系统id
	 */
	private Long id;
    
    	/**
	 * 内容
	 */
	private String content;
    
    	/**
	 * 企业职位表id
	 */
	private Long companyPositionId;
    
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
