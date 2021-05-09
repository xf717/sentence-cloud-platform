package com.db.chaomaxs.companyweb.controller.collect.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 企业_用户_收藏
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyUserCollectCreateDTO", description = "添加企业_用户_收藏")
public class CompanyUserCollectAddDTO {

    @ApiModelProperty(name = "positionId", value = "职位id")
    private Long positionId;

    @ApiModelProperty(name = "userId", value = "用户id")
    private Long userId;


}
