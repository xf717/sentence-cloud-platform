package com.db.chaomaxs.userweb.service.postition.vo;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;


/**
 * @author momo
 * @date 2021-04-30 10:15
 */
@Data
public class PositionDetailVO {

  @ApiModelProperty(name = "positionName", value = "职位名称")
  private String positionName;

  @ApiModelProperty(name = "startSalary", value = "最低薪资")
  private Integer startSalary;

  @ApiModelProperty(name = "endSalary", value = "最高薪资")
  private Integer endSalary;

  @ApiModelProperty(name = "yearSalary", value = "年终奖")
  private Integer yearSalary;

  @ApiModelProperty(name = "cityCode", value = "市")
  private String cityCode;

  @ApiModelProperty(name = "areaCode", value = "区")
  private String areaCode;

  @ApiModelProperty(name = "businessDistrict", value = "商圈")
  private String businessDistrict;

  @ApiModelProperty(name = "experience", value = "经验要求")
  private String experience;

  @ApiModelProperty(name = "education", value = "学历")
  private String education;

  @ApiModelProperty(name = "realName", value = "企业用户名")
  private String realName;

  @ApiModelProperty(name = "photo", value = "头像")
  private String photo;

  @ApiModelProperty(name = "shortName", value = "公司简称")
  private String shortName;

  @ApiModelProperty(name = "keywordList", value = "关键字")
  private List<PositionKeywordVO> keywordList;

  @ApiModelProperty(name = "content", value = "工作内容和岗位要求")
  private String content;

  @ApiModelProperty(name = "logoUrl", value = "公司logo")
  private String logoUrl;

  @ApiModelProperty(name = "fullName", value = "公司全称")
  private String fullName;

  @ApiModelProperty(name = "developmentStage", value = "发展阶段")
  private String developmentStage;

  @ApiModelProperty(name = "companyScope", value = "公司规模")
  private String companyScope;

  @ApiModelProperty(name = "industryName", value = "行业")
  private String industryName;

  @ApiModelProperty(name = "longitude", value = "经度")
  private BigDecimal longitude;

  @ApiModelProperty(name = "latitude", value = "纬度")
  private BigDecimal latitude;
}
