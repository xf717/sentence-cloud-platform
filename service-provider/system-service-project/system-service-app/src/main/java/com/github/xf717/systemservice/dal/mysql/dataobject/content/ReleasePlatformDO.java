package com.github.xf717.systemservice.dal.mysql.dataobject.content;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.xf717.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;



/**
 * 发布平台
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("release_platform")
public class ReleasePlatformDO extends DeletableDO{

    	/**
	 * 系统id
	 */
	private Long id;
    
    	/**
	 * 发布平台类型:1.发布平台模块  2.消息通知模块
	 */
	private Integer releasePlatformType;
    
    	/**
	 * 信息ID
	 */
	private Long infoId;
    
    	/**
	 * 类型(1-消息,2-通知)
	 */
	private Integer type;
    
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
