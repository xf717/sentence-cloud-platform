package com.github.xf717.userservice.dal.mysql.dataobject.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.xf717.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;



/**
 * 记录用户签到记录信息
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_integral_record")
public class UserIntegralRecordDO extends DeletableDO{

    	/**
	 * 系统id
	 */
	private Long id;
    
    	/**
	 * 用户id
	 */
	private Long userId;
    
    	/**
	 * 手机号码
	 */
	private String mobile;
    
    	/**
	 * 连续签到天数
	 */
	private Integer checkDay;
    
    	/**
	 * 签到时间
	 */
	private Date signInTime;
    
    	/**
	 * 积分说明,字典表id
	 */
	private Long integralExplanationDictionaryId;
    
    	/**
	 * 积分类型:关联字典表id
	 */
	private Long integralTypeDictionaryId;
    
    	/**
	 * 积分值
	 */
	private Integer integralValue;
    
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
