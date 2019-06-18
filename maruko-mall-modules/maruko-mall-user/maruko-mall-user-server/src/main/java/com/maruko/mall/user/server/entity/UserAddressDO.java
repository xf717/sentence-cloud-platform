package com.maruko.mall.user.server.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * 用户收货地址
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Table(name = "user_address")
@Data
@Accessors(chain = true)
public class UserAddressDO implements Serializable {
	private static final long serialVersionUID = 1L;

	    /**
     * 主键id
     */
    @Id
    private Integer addressId;
	
	    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;
	
	    /**
     * 省分id
     */
    @Column(name = "province_id")
    private Integer provinceId;
	
	    /**
     * 市ID
     */
    @Column(name = "city_id")
    private Integer cityId;
	
	    /**
     * 县区id
     */
    @Column(name = "county_id")
    private Integer countyId;
	
	    /**
     * 手机号码
     */
    @Column(name = "mobile")
    private String mobile;
	
	    /**
     * 详细地址
     */
    @Column(name = "address")
    private String address;
	
	    /**
     * 联系人
     */
    @Column(name = "contact")
    private String contact;
	
	    /**
     * 是否默认
     */
    @Column(name = "is_default")
    private Integer isDefault;
	
	    /**
     * 别名
     */
    @Column(name = "alias")
    private String alias;
	
	    /**
     * 备注
     */
    @Column(name = "notes")
    private String notes;
	
	    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;
	
	    /**
     * 创建者
     */
    @Column(name = "create_by")
    private Integer createBy;
	
	    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Long modifyTime;
	
	    /**
     * 修改者
     */
    @Column(name = "modify_by")
    private Integer modifyBy;
	

}
