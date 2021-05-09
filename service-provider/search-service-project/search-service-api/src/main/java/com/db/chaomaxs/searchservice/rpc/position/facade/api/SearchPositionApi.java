package com.db.chaomaxs.searchservice.rpc.position.facade.api;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.searchservice.rpc.position.dto.SearchPositionPageReqDTO;
import com.db.chaomaxs.searchservice.rpc.position.dto.SearchPositionRespDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * SearchPositionApi
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/28 16:03
 */
public interface SearchPositionApi {

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/position/page/search")
  TableResultResponse<SearchPositionRespDTO> pageSearchPosition(
      @RequestBody SearchPositionPageReqDTO pageReqDTO);


}
