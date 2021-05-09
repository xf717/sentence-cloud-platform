package com.db.chaomaxs.companyweb.controller.track.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 企业我的足迹
 *
 * @author momo
 * @date 2021-03-26 10:18:32
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
@ApiModel(value = "CompanyUserTrackCreateDTO", description = "添加企业我的足迹")
public class CompanyUserTrackAddDTO {
    /**
     * 职位id
     */
    @ApiModelProperty(name = "positionId", value = "职位id")
    private Long positionId;

    /**
     * 用户id
     */
    @ApiModelProperty(name = "userId", value = "用户id")
    private Long userId;

}
