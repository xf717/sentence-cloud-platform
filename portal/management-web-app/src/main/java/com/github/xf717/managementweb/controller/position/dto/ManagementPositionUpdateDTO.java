package com.github.xf717.managementweb.controller.position.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;


/**
 * 企业_职位
 *
 * @author momo
 * @date 2021-04-14 16:57:09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyPositionUpdateDTO", description = "更新企业_职位")
public class ManagementPositionUpdateDTO {

    /**
     * 系统id
     */
    @ApiModelProperty(name = "id", value = "系统id")
    private Long id;

    /**
     * 职位名称
     */
    @ApiModelProperty(name = "positionName", value = "职位名称")
    @NotBlank(message = "职位名称不能为空")
    @Length(max = 25, message = "职位名称最多只能输入25个字")
    private String positionName;

    /**
     * 职位类别id,关联职位分类表id
     */
    @ApiModelProperty(name = "positionTypeId", value = "职位类别id,关联职位分类表id")
    @NotBlank(message = "职位类别不能为空")
    private Long positionTypeId;

    /**
     * 职位关键字
     */
    @ApiModelProperty(name = "positionKeywordIds", value = "职位关键字id")
    @NotEmpty(message = "职位关键字不能为空")
    @Size(max = 6, message = "职位标签最多只能添加6个")
    private List<Long> positionKeywordIds;

    /**
     * 经验要求：关联经验要求表主键id
     */
    @ApiModelProperty(name = "experienceId", value = "经验要求：关联经验要求表主键id")
    @NotBlank(message = "经验要求不能为空")
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
    @NotBlank(message = "最低学历不能为空")
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
    @NotBlank(message = "薪资范围不能为空")
    private Integer startSalary;

    /**
     * 最高薪资
     */
    @ApiModelProperty(name = "endSalary", value = "最高薪资")
    @NotBlank(message = "薪资范围不能为空")
    private Integer endSalary;

    @ApiModelProperty(name = "yearSalary", value = "年终奖")
    @NotBlank(message = "年终奖不能为空")
    private Integer yearSalary;

    /**
     * 职位描述
     */
    @ApiModelProperty(name = "content", value = "职位描述")
    @NotBlank(message = "职位描述不能为空")
    @Size(max = 5000, message = "职位描述最多只能填写5000字")
    private String content;

    /**
     * 省份
     */
    @ApiModelProperty(name = "provinceCode", value = "省份")
    @NotBlank(message = "工作地址不能为空")
    private String provinceCode;

    /**
     * 城市
     */
    @ApiModelProperty(name = "cityCode", value = "城市")
    @NotBlank(message = "工作地址不能为空")
    private String cityCode;

    /**
     * 区
     */
    @ApiModelProperty(name = "areaCode", value = "区")
    @NotBlank(message = "工作地址不能为空")
    private String areaCode;

    /**
     * 详细地址(街道)
     */
    @ApiModelProperty(name = "street", value = "详细地址(街道)")
    @NotBlank(message = "工作地址不能为空")
    private String street;

    /**
     * 详细地址(完整地址)
     */
    @ApiModelProperty(name = "address", value = "详细地址(完整地址)")
    @NotBlank(message = "工作地址不能为空")
    private String address;

    /**
     * 地图上地址
     */
    @ApiModelProperty(name = "mapAddress", value = "地图上地址")
    @NotBlank(message = "工作地址不能为空")
    private String mapAddress;

    /**
     * 经度
     */
    @ApiModelProperty(name = "longitude", value = "经度")
    @NotBlank(message = "工作地址不能为空")
    private BigDecimal longitude;

    /**
     * 纬度
     */
    @ApiModelProperty(name = "latitude", value = "纬度")
    @NotBlank(message = "工作地址不能为空")
    private BigDecimal latitude;

    /**
     * 商圈
     */
    @ApiModelProperty(name = "businessDistrict", value = "商圈")
    private String businessDistrict;


}
