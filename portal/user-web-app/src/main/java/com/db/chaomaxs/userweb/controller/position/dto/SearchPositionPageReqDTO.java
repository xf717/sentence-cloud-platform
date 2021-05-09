package com.db.chaomaxs.userweb.controller.position.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 职位搜索请求参数
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/28 15:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "PositionSearchReqDTO", description = "职位搜索")
public class SearchPositionPageReqDTO extends PageParam {
  
  private static final long serialVersionUID = -3751396841549812215L;
  /**
   * 搜索关键字，职位或者公司
   */
  @ApiModelProperty(value = "搜索关键字，职位或者公司", example = "java")
  private String searchKeyWord;

  @ApiModelProperty(value = "关键字", example = "java")
  private List<Long> keywordIds;

  /**
   * 城市编码 ，根据城市搜索
   */
  @ApiModelProperty(value = "城市编码", example = "厦门")
  private String cityCode;

  /**
   * 学历要求
   */
  @ApiModelProperty(value = "学历要求", example = "1")
  private List<Long> educationIds;

  @ApiModelProperty(value = "薪资待遇", example = "10")
  private Long salaryId;


  /**
   * 经验要求
   */
  @ApiModelProperty(value = "经验要求", example = "1")
  private List<Long> experienceIds;

  @ApiModelProperty(value = "行业要求", example = "1")
  @Min(value = 1, message = "行业id最小值为1")
  private List<Long> industryIds;

  @ApiModelProperty(value = "公司规模", example = "1")
  private List<Long> scopeIds;

  @ApiModelProperty(value = "融资阶段", example = "1")
  private List<Long> developmentStageIds;


}
