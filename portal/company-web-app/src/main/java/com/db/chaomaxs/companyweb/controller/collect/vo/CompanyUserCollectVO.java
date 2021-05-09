package com.db.chaomaxs.companyweb.controller.collect.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业_用户_收藏
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyUserCollectVO", description = "企业_用户_收藏")
public class CompanyUserCollectVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(name = "id", value = "主键id")
    private Long id;


}
