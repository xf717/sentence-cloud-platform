package com.db.chaomaxs.userweb.controller.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 用户_常用语
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserWordUpdateDTO", description = "更新用户_常用语")
public class UserWordUpdateDTO {

    /**
     *
     */
    @ApiModelProperty(name = "id", value = "")
    private Long id;

    /**
     * 内容
     */
    @ApiModelProperty(name = "content", value = "内容")
    private String content;
}
