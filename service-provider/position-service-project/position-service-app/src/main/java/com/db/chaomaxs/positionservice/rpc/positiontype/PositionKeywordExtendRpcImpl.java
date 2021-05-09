package com.db.chaomaxs.positionservice.rpc.positiontype;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.manager.positiontype.PositionKeywordExtendManager;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.facade.PositionKeywordExtendRpcFacade;
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
public class PositionKeywordExtendRpcImpl implements PositionKeywordExtendRpcFacade {

  @Autowired
  private PositionKeywordExtendManager positionKeywordExtendManager;

  @Override
  public BaseResponse save(PositionKeywordExtendCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    positionKeywordExtendManager.savePositionKeywordExtend(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(PositionKeywordExtendUpdateReqDTO updateReqDTO) {
      positionKeywordExtendManager.updatePositionKeywordExtend(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      positionKeywordExtendManager.deletePositionKeywordExtend(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<PositionKeywordExtendRespDTO> getPositionKeywordExtendById(Long id) {
      PositionKeywordExtendRespDTO positionKeywordExtend = positionKeywordExtendManager.getPositionKeywordExtendById(id);
    return new ObjectRestResponse<>().data(positionKeywordExtend);
  }

  @Override
  public ObjectRestResponse<List<PositionKeywordExtendRespDTO>> listPositionKeywordExtends(PositionKeywordExtendListQueryReqDTO listQuery) {
    List<PositionKeywordExtendRespDTO> list = positionKeywordExtendManager.listPositionKeywordExtends(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<PositionKeywordExtendRespDTO> page(PositionKeywordExtendPageReqDTO pageReqDTO) {
    PageResult<PositionKeywordExtendRespDTO> pageResult = positionKeywordExtendManager.pagePositionKeywordExtend(pageReqDTO);
    TableResultResponse<PositionKeywordExtendRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
