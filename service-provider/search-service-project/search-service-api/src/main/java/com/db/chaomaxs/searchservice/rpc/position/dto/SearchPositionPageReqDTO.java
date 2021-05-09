package com.db.chaomaxs.searchservice.rpc.position.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import com.db.chaomaxs.common.framework.vo.SortingField;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 职位搜索
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@Data
@Accessors(chain = true)
public class SearchPositionPageReqDTO extends PageParam {

  private static final long serialVersionUID = 3672734429207520054L;

  /**
   * 搜索关键字
   */
  private String searchKeyWord;

  /**
   * 关键词
   */
  private List<Long> keywordIds;

  /**
   * 城市编码 ，根据城市搜索
   */
  private String cityCode;

  /**
   * 学历要求
   */
  private List<Long> educationIds;

  /**
   * 薪资待遇
   */
  private Long salaryId;

  /**
   * 经验要求
   */
  private List<Long> experienceIds;

  /**
   * 行业id
   */
  private List<Long> industryIds;

  
  private List<Long> scopeIds;

  private List<Long> developmentStageIds;
  /**
   * 排序字段数组
   * <p>
   * 可支持排序的字段，见 {@link }
   */
  private List<SortingField> sorts;


}
