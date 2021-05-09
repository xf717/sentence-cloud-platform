package com.github.xf717.searchservice.rpc.position;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.searchservice.manager.position.SearchPositionManager;
import com.github.xf717.searchservice.rpc.position.dto.SearchPositionPageReqDTO;
import com.github.xf717.searchservice.rpc.position.dto.SearchPositionRespDTO;
import com.github.xf717.searchservice.rpc.position.facade.SearchPositionRpcFacade;
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
