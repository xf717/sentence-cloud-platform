package com.github.xf717.managementweb.controller.position.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.math.BigDecimal;


/**
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-14 16:57:09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ManagementPositionVO", description = "企业_职位")
public class ManagementPositionVO {

    /**
     * 系统id
     */
    @ApiModelProperty(name = "id", value = "系统id")
    private Long id;

    /**
     * 职位名称
     */
    @ApiModelProperty(name = "positionName", value = "职位名称")
    private String positionName;

    /**
     * 企业ID
     */
    @ApiModelProperty(name = "companyId", value = "企业ID")
    private Long companyId;

    /**
     * 企业用户ID
     */
    @ApiModelProperty(name = "companyUserId", value = "企业用户ID")
    private Long companyUserId;

    /**
     * 职位类别id,关联职位分类表id
     */
    @ApiModelProperty(name = "positionTypeId", value = "职位类别id,关联职位分类表id")
    private Long positionTypeId;

    /**
     * 经验要求：关联经验要求表主键id
     */
    @ApiModelProperty(name = "experienceId", value = "经验要求：关联经验要求表主键id")
    private Long experienceId;

    /**
     * 经验要求：冗余字段
     */
    @ApiModelProperty(name = "experience", value = "经验要求：冗余字段")
    private String experience;

    /**
     * 学历ID，字典表主键ID
     */
    @ApiModelProperty(name = "educationId", value = "学历ID，字典表主键ID")
    private Long educationId;

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
     * 职位描述
     */
    @ApiModelProperty(name = "description", value = "职位描述")
    private String description;

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
     * 区
     */
    @ApiModelProperty(name = "areaCode", value = "区")
    private String areaCode;

    /**
     * 详细地址(街道)
     */
    @ApiModelProperty(name = "street", value = "详细地址(街道)")
    private String street;

    /**
     * 详细地址(完整地址)
     */
    @ApiModelProperty(name = "address", value = "详细地址(完整地址)")
    private String address;

    /**
     * 地图上地址
     */
    @ApiModelProperty(name = "mapAddress", value = "地图上地址")
    private String mapAddress;

    /**
     * 经度
     */
    @ApiModelProperty(name = "longitude", value = "经度")
    private BigDecimal longitude;

    /**
     * 纬度
     */
    @ApiModelProperty(name = "latitude", value = "纬度")
    private BigDecimal latitude;

    /**
     * 商圈
     */
    @ApiModelProperty(name = "businessDistrict", value = "商圈")
    private String businessDistrict;

    /**
     * 发布状态：0：待审核 1、 已通过 2、已拒绝 3、关闭
     */
    @ApiModelProperty(name = "status", value = "发布状态：0：待审核 1、 已通过 2、已拒绝 3、关闭")
    private Integer status;


}
