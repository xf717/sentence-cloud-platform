package com.db.chaomaxs.searchservice.rpc.position;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.searchservice.manager.position.SearchPositionManager;
import com.db.chaomaxs.searchservice.rpc.position.dto.SearchPositionPageReqDTO;
import com.db.chaomaxs.searchservice.rpc.position.dto.SearchPositionRespDTO;
import com.db.chaomaxs.searchservice.rpc.position.facade.SearchPositionRpcFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SearchPositionRpcImpl
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/30 9:50
 */
@Service
public class SearchPositionRpcImpl implements SearchPositionRpcFacade {

  @Autowired
  private SearchPositionManager searchPositionManager;

  @Override
  public TableResultResponse<SearchPositionRespDTO> pageSearchPosition(
      SearchPositionPageReqDTO pageReqDTO) {
    PageResult<SearchPositionRespDTO> pageRequest = searchPositionManager
        .pageSearchPosition(pageReqDTO);
    TableResultResponse<SearchPositionRespDTO> tableResultResponse = new TableResultResponse<>(
        pageRequest.getTotal(), pageRequest.getList());
    return tableResultResponse;
  }
}
