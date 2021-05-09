package com.db.chaomaxs.userweb.controller.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 企业投递表
 *
 * @author momo
 * @date 2021-04-08 14:18:28
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserDeliveryCreateDTO", description = "添加企业投递表")
public class UserDeliveryAddDTO {


    /**
     * 用户id
     */
    @ApiModelProperty(name = "userId", value = "用户id")
    private Long userId;

    /**
     * 企业用户id
     */
    @ApiModelProperty(name = "companyUserId", value = "企业用户id")
    private Long companyUserId;

    /**
     * 企业id
     */
    @ApiModelProperty(name = "companyId", value = "企业id")
    private Long companyId;

    /**
     * 职位id
     */
    @ApiModelProperty(name = "positionId", value = "职位id")
    private Long positionId;


}
