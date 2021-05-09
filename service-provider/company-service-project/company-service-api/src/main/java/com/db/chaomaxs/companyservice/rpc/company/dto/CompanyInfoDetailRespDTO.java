package com.db.chaomaxs.companyservice.rpc.company.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 公司信息详情，包含产品图片、福利
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class CompanyInfoDetailRespDTO implements Serializable {

  private static final long serialVersionUID = 7632568991190070168L;
  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 企业用户ID
   */
  private Long userId;
  /**
   * 企业LOGO图片地址
   */
  private String logoUrl;

  /**
   * 所属行业id,关联行业字典表id
   */
  private Long industryId;

  /**
   * 所属行业名称,冗余字段
   */
  private String industryName;

  /**
   * 市名称
   */
  private String cityName;

  /**
   * 详细地址
   */
  private String address;

  /**
   * 公司全称
   */
  private String fullName;

  /**
   * 公司简称
   */
  private String shortName;

  /**
   * 公司规模,关联数据字典表id
   */
  private Long scopeDictionaryId;

  /**
   * 发展阶段
   */
  private Long developmentStageDictionaryId;

  /**
   * 工作开始时间
   */
  private Date startWorkTime;

  /**
   * 工作结束时间
   */
  private Date endWorkTime;

  /**
   * 休息时间
   */
  private Long restTimeDictionaryId;

  /**
   * 加班情况,字典表id
   */
  private Long workOvertimeDictionaryId;

  /**
   * 公司简介
   */
  private String intro;

  /**
   * 公司福利
   */
  private List<CompanyWelfareRespDTO> companyWelfareList;

  /**
   * 公司图片
   */
  private List<CompanyPhotoRespDTO> companyPhotoList;

  /**
   * 公司产品
   */
  private List<CompanyProductRespDTO> companyProductList;


}
