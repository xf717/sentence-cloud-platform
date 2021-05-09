package com.github.xf717.userweb.service.postition.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * @author momo
 * @date 2021-04-30 10:15
 */
@Data
public class PositionVO {

    @ApiModelProperty(name = "positionName", value = "职位名称")
    private String positionName;


    @ApiModelProperty(name = "startSalary", value = "最低薪资")
    private Integer startSalary;

    @ApiModelProperty(name = "endSalary", value = "最高薪资")
    private Integer endSalary;


    @ApiModelProperty(name = "experience", value = "经验要求")
    private String experience;

    @ApiModelProperty(name = "education", value = "学历")
    private String education;

    @ApiModelProperty(name = "companyName", value = "公司名称")
    private String companyName;

    @ApiModelProperty(name = "developmentStage", value = "发展阶段")
    private String developmentStage;

    @ApiModelProperty(name = "companyScope", value = "公司规模")
    private String companyScope;


    @ApiModelProperty(name = "realName", value = "企业用户名")
    private String realName;

    @ApiModelProperty(name = "photo", value = "头像")
    private String photo;


    @ApiModelProperty(name = "areaCode", value = "区")
    private String areaCode;

    @ApiModelProperty(name = "businessDistrict", value = "商圈")
    private String businessDistrict;

    @ApiModelProperty(name = "status", value = "发布状态")
    private String status;

    @ApiModelProperty(name = "status", value = "发布状态")
    private String updateTime;

    @ApiModelProperty(name = "keywordList", value = "关键字")
    private List<PositionKeywordVO> keywordList;

}
