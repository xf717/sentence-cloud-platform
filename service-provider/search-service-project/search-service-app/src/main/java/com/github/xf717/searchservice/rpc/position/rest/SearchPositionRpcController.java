package com.github.xf717.searchservice.rpc.position.rest;


import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.searchservice.rpc.position.SearchPositionRpcImpl;
import com.github.xf717.searchservice.rpc.position.dto.SearchPositionPageReqDTO;
import com.github.xf717.searchservice.rpc.position.dto.SearchPositionRespDTO;
import com.github.xf717.searchservice.rpc.position.facade.api.SearchPositionApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 搜索职位
 *
 * @author xiaofeng
 * @date 2021-04-22 13:59
 */
@RestController
public class SearchPositionRpcController implements SearchPositionApi {

  @Autowired
  private SearchPositionRpcImpl searchPositionRpc;

  @Override
  public TableResultResponse<SearchPositionRespDTO> pageSearchPosition(
      SearchPositionPageReqDTO pageReqDTO) {
    return searchPositionRpc.pageSearchPosition(pageReqDTO);
  }


}
