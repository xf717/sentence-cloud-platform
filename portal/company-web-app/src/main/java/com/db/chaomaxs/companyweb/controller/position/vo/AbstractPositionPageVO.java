package com.db.chaomaxs.companyweb.controller.position.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-14 16:57:09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "AbstractPositionPageVO", description = "企业_职位")
public class AbstractPositionPageVO{

    @ApiModelProperty(name = "id", value = "主键id")
    private String id;
    /**
     * 职位名称
     */
    @ApiModelProperty(name = "positionName", value = "职位名称")
    private String positionName;


    /**
     * 经验要求：冗余字段
     */
    @ApiModelProperty(name = "experience", value = "经验要求：冗余字段")
    private String experience;

    /**
     * 学历
     */
    @ApiModelProperty(name = "education", value = "学历")
    private String education;

    /**
     * 最低薪资
     */
    @ApiModelProperty(name = "startSalary", value = "最低薪资")
    private Integer startSalary;

    /**
     * 最高薪资
     */
    @ApiModelProperty(name = "endSalary", value = "最高薪资")
    private Integer endSalary;

    /**
     * 城市
     */
    @ApiModelProperty(name = "cityCode", value = "城市")
    private String cityCode;

    /**
     * 商圈
     */
    @ApiModelProperty(name = "businessDistrict", value = "商圈")
    private String businessDistrict;

    /**
     * 发布状态：0：待审核 1、 已通过 2、已拒绝 3、关闭
     */
    @ApiModelProperty(name = "status", value = "发布状态")
    private String status;



}
