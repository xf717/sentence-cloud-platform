package com.db.chaomaxs.companyweb.controller.position.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-14 17:16:58
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyPositionKeywordCreateDTO", description = "添加企业_职位")
public class CompanyPositionKeywordAddDTO {
    /**
     * 职位关键字id
     */
    @ApiModelProperty(name = "positionKeywordId", value = "职位关键字id")
    private Long positionKeywordId;
}
