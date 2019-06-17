package com.maruko.mall.user.server.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_积分表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Table(name = "user_integral")
@Data
@Accessors(chain = true)
public class UserIntegralDO implements Serializable {
	private static final long serialVersionUID = 1L;

	    /**
     * 系统id
     */
    @Id
    private Integer userIntegralId;
	
	    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;
	
	    /**
     * 总积分
     */
    @Column(name = "total_integral")
    private Integer totalIntegral;
	
	    /**
     * 积分
     */
    @Column(name = "integral")
    private Integer integral;
	
	    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;
	
	    /**
     * 创建人
     */
    @Column(name = "create_by")
    private Integer createBy;
	
	    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Long modifyTime;
	
	    /**
     * 修改人
     */
    @Column(name = "modify_by")
    private Integer modifyBy;
	

}
