package com.db.chaomaxs.searchservice.manager.position;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.searchservice.rpc.position.dto.SearchPositionPageReqDTO;
import com.db.chaomaxs.searchservice.rpc.position.dto.SearchPositionRespDTO;
import com.db.chaomaxs.searchservice.service.position.SearchPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SearchPositionManager
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/28 18:25
 */
@Service
public class SearchPositionManager {

  @Autowired
  private SearchPositionService searchPositionService;

  public PageResult<SearchPositionRespDTO> pageSearchPosition(SearchPositionPageReqDTO pageReqDTO) {
    PageResult<SearchPositionRespDTO> pageResult = searchPositionService
        .pageSearchPosition(pageReqDTO);
    return pageResult;
  }

  public PageResult<SearchPositionRespDTO> pageSearchPositionHighLevel(
      SearchPositionPageReqDTO pageReqDTO) {
    return searchPositionService.pageSearchPositionHighLevel(pageReqDTO);
  }

  /**
   * 重新构建索引
   *
   * @return
   */
  public Integer rebuild() {
    return null;
  }

}
