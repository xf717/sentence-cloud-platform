package com.github.xf717.userweb.controller.user.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 用户面试表
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserInterviewCreateDTO", description = "添加用户面试表")
public class UserInterviewAddDTO {

    /**
     * 主键id
     */
    @ApiModelProperty(name = "id", value = "主键id")
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty(name = "userId", value = "用户id")
    private Long userId;

    /**
     * 企业用户面试表id
     */
    @ApiModelProperty(name = "companyUserInterviewId", value = "企业用户面试表id")
    private Long companyUserInterviewId;

    /**
     * 手机号
     */
    @ApiModelProperty(name = "mobile", value = "手机号")
    private String mobile;

    /**
     * 状态
     * 0 -  待接受面试
     * 1 -  待面试
     * 2 -  拒绝面试
     * 3 - 通过面试
     * 4 - 拒绝录用
     * 5-  接受录用
     * 6 - 企业已取消
     * 7 - 用户已取消
     */
    @ApiModelProperty(name = "status", value = "状态 0 -  待接受面试 1 -  待面试 2 -  拒绝面试 3 - 通过面试 4 - 拒绝录用 5-  接受录用 6 - 企业已取消 7 - 用户已取消")
    private Integer status;

    /**
     * 是否删除 0 -  否  1 - 是
     */
    @ApiModelProperty(name = "isDeleted", value = "是否删除 0 -  否  1 - 是")
    private Integer isDeleted;

    /**
     * 创建人
     */
    @ApiModelProperty(name = "createBy", value = "创建人")
    private Long createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @ApiModelProperty(name = "updateBy", value = "修改人")
    private Long updateBy;

    /**
     * 修改时间
     */
    @ApiModelProperty(name = "updateTime", value = "修改时间")
    private Date updateTime;


}
