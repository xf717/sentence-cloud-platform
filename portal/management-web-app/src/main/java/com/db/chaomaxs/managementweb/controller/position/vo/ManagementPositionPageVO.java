package com.db.chaomaxs.managementweb.controller.position.vo;

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
@ApiModel(value = "CompanyPositionVO", description = "企业_职位")
public class ManagementPositionPageVO {

    @ApiModelProperty(name = "id", value = "职位id        ")
    private String id;

    /**
     * 职位名称
     */
    @ApiModelProperty(name = "positionName", value = "职位名称")
    private String positionName;


    /**
     * 职位类别
     */
    @ApiModelProperty(name = "positionTypeName", value = "职位类别名")
    private Long positionTypeName;

    /**
     * 省份
     */
    @ApiModelProperty(name = "provinceCode", value = "省份")
    private String provinceCode;

    /**
     * 城市
     */
    @ApiModelProperty(name = "cityCode", value = "城市")
    private String cityCode;

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
     * 经验要求
     */
    @ApiModelProperty(name = "experience", value = "经验要求")
    private String experience;

    /**
     * 学历
     */
    @ApiModelProperty(name = "education", value = "学历")
    private String education;

    /**
     * 学历
     */
    @ApiModelProperty(name = "fullName", value = "企业名称")
    private String fullName;

    /**
     * 企业名称
     */
    @ApiModelProperty(name = "realName", value = "创建人")
    private String realName;

    /**
     * 发布状态
     */
    @ApiModelProperty(name = "status", value = "发布状态")
    private String status;
    /**
     * 企业名称
     */
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private String createTime;




}
