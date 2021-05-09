package com.db.chaomaxs.userweb.controller.position.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author xiaofeng
 * @version 1.0
 * @description: TODO
 * @date 2021/4/23 16:36
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyInfoDetailVO", description = "公司详细信息")
public class CompanyInfoDetailVO implements Serializable {

  private static final long serialVersionUID = 3866501736046556710L;
  /**
   * 主键id
   */
  @ApiModelProperty(name = "id", value = "公司id")
  private Long id;

  /**
   * 公司用户id
   */
  @ApiModelProperty(name = "companyUserId", value = "公司用户id")
  private Long companyUserId;

  /**
   * 企业LOGO图片地址
   */
  @ApiModelProperty(name = "logoUrl", value = "企业LOGO图片地址")
  private String logoUrl;

  /**
   * 市名称
   */
  @ApiModelProperty(name = "cityName", value = "城市名称")
  private String cityName;

  /**
   * 公司全称
   */
  @ApiModelProperty(name = "fullName", value = "公司全称")
  private String fullName;

  /**
   * 公司简称
   */
  @ApiModelProperty(name = "shortName", value = "公司简称")
  private String shortName;

  /**
   * 发展阶段名称
   */
  @ApiModelProperty(name = "developmentStageDictionaryName", value = "发展阶段")
  private String developmentStageDictionaryName;

  /**
   * 公司模块名称
   */
  @ApiModelProperty(name = "scopeDictionaryName", value = "公司规模")
  private String scopeDictionaryName;

  /**
   * 所属行业名称,冗余字段
   */
  @ApiModelProperty(name = "industryName", value = "所属行业名称,冗余字段")
  private String industryName;

  /**
   * 开始工作时间
   */
  @ApiModelProperty(name = "startWorkTime", value = "开始工作时间")
  private Date startWorkTime;

  /**
   * 结束工作时间
   */
  @ApiModelProperty(name = "endWorkTime", value = "结束工作时间")
  private Date endWorkTime;

  /**
   * 休息时间
   */
  @ApiModelProperty(name = "restTimeDictionaryName", value = "休息时间")
  private String restTimeDictionaryName;

  /**
   * 加班情况
   */
  @ApiModelProperty(name = "workOvertimeDictionaryName", value = "加班情况")
  private String workOvertimeDictionaryName;


  /**
   * 详细地址
   */
  @ApiModelProperty(name = "address", value = "地址")
  private String address;

  /**
   * 公司简介
   */
  @ApiModelProperty(name = "intro", value = "公司简介")
  private String intro;

  @ApiModelProperty(name = "companyWelfareList", value = "公司福利列表")
  private List<CompanyWelfareVO> companyWelfareList;

  @ApiModelProperty(name = "companyPhotoList", value = "公司图片列表")
  private List<CompanyPhotoVO> companyPhotoList;


  @ApiModelProperty(name = "companyProductList", value = "公司产品图片")
  private List<CompanyProductVO> companyProductList;

  /**
   * 福利
   */
  @Data
  @Accessors(chain = true)
  public static class CompanyWelfareVO {

    /**
     * 福利id
     */
    @ApiModelProperty(name = "id", value = "福利id")
    @NotEmpty(message = "福利id")
    private Long id;

    /**
     * 福利名称
     */
    @ApiModelProperty(name = "name", value = "福利名称")
    private String name;

    /**
     * 图标url
     */
    @ApiModelProperty(name = "iconUrl", value = "福利图标")
    private String iconUrl;
  }


  /**
   * 公司图片
   */
  @Data
  @Accessors(chain = true)
  public static class CompanyPhotoVO {

    /**
     * 图片id
     */
    @ApiModelProperty(name = "id", value = "图片id")
    @NotEmpty(message = "图片id")
    private Long id;

    /**
     * 相片存储地址
     */
    @ApiModelProperty(name = "photoUrl", value = "图片地址")
    private String photoUrl;
  }

  /**
   * 公司产品
   */
  @Data
  @Accessors(chain = true)
  public static class CompanyProductVO {

    /**
     * 系统id
     */
    @ApiModelProperty(name = "id", value = "产品id")
    @NotEmpty(message = "产品id")
    private Long id;

    /**
     * 产品logo图片地址
     */
    @ApiModelProperty(name = "logoUrl", value = "产品图片地址")
    private String logoUrl;

    /**
     * 产品名称
     */
    @ApiModelProperty(name = "productName", value = "产品名称")
    private String productName;
  }


}
