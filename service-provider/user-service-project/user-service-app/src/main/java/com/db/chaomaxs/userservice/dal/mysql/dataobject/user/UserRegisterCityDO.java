package com.db.chaomaxs.userservice.dal.mysql.dataobject.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;



/**
 * 用户注册城市表，注册时保存
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_register_city")
public class UserRegisterCityDO extends DeletableDO{

    	/**
	 * 吐槽id
	 */
	private Long 主键id;
    
    	/**
	 * 用户id
	 */
	private Long userId;
    
    	/**
	 * 省名称
	 */
	private String provinceName;
    
    	/**
	 * 省编号
	 */
	private String provinceCode;
    
    	/**
	 * 城市名称
	 */
	private String cityName;
    
    	/**
	 * 市编号
	 */
	private String cityCode;
    
    	/**
	 * 区名称
	 */
	private String areaName;
    
    	/**
	 * 区编号
	 */
	private String areaCode;
    
    	/**
	 * 
	 */
	private String address;
    
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
