package com.github.xf717.managementweb.controller.position.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;


/**
 *
 * 职位审核
 *
 * @author momo
 * @date 2021-04-14 16:57:09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ManagementPositionAuditDTO", description = "职位审核")
public class ManagementPositionAuditDTO {

    @ApiModelProperty(name ="id",value = "职位id")
    private Long id;

    @ApiModelProperty(name ="status", value = "发布状态：0：待审核 1、 已通过 2、已拒绝 3、关闭")
    private Integer statue;

    @Size(max = 200,message = "不通过原因最多只能填200个字")
    private String reason;




}
