package com.db.chaomaxs.positionservice.rpc.positiontype;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.manager.positiontype.PositionKeywordManager;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.facade.PositionKeywordRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Slf4j
@Service
public class PositionKeywordRpcImpl implements PositionKeywordRpcFacade {

  @Autowired
  private PositionKeywordManager positionKeywordManager;

  @Override
  public BaseResponse save(PositionKeywordCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    positionKeywordManager.savePositionKeyword(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(PositionKeywordUpdateReqDTO updateReqDTO) {
      positionKeywordManager.updatePositionKeyword(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      positionKeywordManager.deletePositionKeyword(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<PositionKeywordRespDTO> getPositionKeywordById(Long id) {
      PositionKeywordRespDTO positionKeyword = positionKeywordManager.getPositionKeywordById(id);
    return new ObjectRestResponse<>().data(positionKeyword);
  }

  @Override
  public ObjectRestResponse<List<PositionKeywordRespDTO>> listPositionKeywords(PositionKeywordListQueryReqDTO listQuery) {
    List<PositionKeywordRespDTO> list = positionKeywordManager.listPositionKeywords(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<PositionKeywordRespDTO> page(PositionKeywordPageReqDTO pageReqDTO) {
    PageResult<PositionKeywordRespDTO> pageResult = positionKeywordManager.pagePositionKeyword(pageReqDTO);
    TableResultResponse<PositionKeywordRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
