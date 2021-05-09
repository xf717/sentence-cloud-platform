package com.db.chaomaxs.companyweb.controller.company.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 公司_相册
 *
 * @author hlf
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyPhotoCreateDTO", description = "添加公司_相册")
public class CompanyPhotoAddDTO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 企业公司id
   */
  @ApiModelProperty(name = "companyId", value = "企业公司id")
  private Long companyId;

  /**
   * 相片存储地址
   */
  @ApiModelProperty(name = "photoUrl", value = "相片存储地址")
  private String photoUrl;
}
