package com.github.xf717.userweb.controller.user.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 用户面试表
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@Data
@Accessors(chain = true)
public class UserInterviewDTO {

    	/**
	 * 主键id
	 */
	private Long id;
    
    	/**
	 * 用户id
	 */
	private Long userId;
    
    	/**
	 * 企业用户面试表id
	 */
	private Long companyUserInterviewId;
    
    	/**
	 * 手机号
	 */
	private String mobile;
    
    	/**
	 * 状态
            0 -  待接受面试
            1 -  待面试
            2 -  拒绝面试
            3 - 通过面试
            4 - 拒绝录用
            5-  接受录用 
            6 - 企业已取消
            7 - 用户已取消
	 */
	private Integer status;
    
    	/**
	 * 是否删除 0 -  否  1 - 是
	 */
	private Integer isDeleted;
    
    	/**
	 * 创建人
	 */
	private Long createBy;
    
    	/**
	 * 创建时间
	 */
	private Date createTime;
    
    	/**
	 * 修改人
	 */
	private Long updateBy;
    
    	/**
	 * 修改时间
	 */
	private Date updateTime;
    

}
