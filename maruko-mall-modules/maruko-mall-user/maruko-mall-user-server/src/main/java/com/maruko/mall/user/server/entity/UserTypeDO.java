package com.maruko.mall.user.server.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import javax.persistence.*;


/**
 * 用户_类型表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Table(name = "user_type")
@Data
@Accessors(chain = true)
public class UserTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;

	    /**
     * id(不能做成自增长)
     */
    @Id
    private Integer userTypeId;
	
	    /**
     * 用户类型名称
     */
    @Column(name = "user_type_name")
    private String userTypeName;
	
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
