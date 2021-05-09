package com.db.chaomaxs.positionservice.rpc.positiontype;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.manager.positiontype.PositionTypeManager;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypePageReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.facade.PositionTypeRpcFacade;
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
public class PositionTypeRpcImpl implements PositionTypeRpcFacade {

  @Autowired
  private PositionTypeManager positionTypeManager;

  @Override
  public BaseResponse save(PositionTypeCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    positionTypeManager.savePositionType(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(PositionTypeUpdateReqDTO updateReqDTO) {
      positionTypeManager.updatePositionType(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      positionTypeManager.deletePositionType(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<PositionTypeRespDTO> getPositionTypeById(Long id) {
      PositionTypeRespDTO positionType = positionTypeManager.getPositionTypeById(id);
    return new ObjectRestResponse<>().data(positionType);
  }

  @Override
  public ObjectRestResponse<List<PositionTypeRespDTO>> listPositionTypes(PositionTypeListQueryReqDTO listQuery) {
    List<PositionTypeRespDTO> list = positionTypeManager.listPositionTypes(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<PositionTypeRespDTO> page(PositionTypePageReqDTO pageReqDTO) {
    PageResult<PositionTypeRespDTO> pageResult = positionTypeManager.pagePositionType(pageReqDTO);
    TableResultResponse<PositionTypeRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }


  /**
   * 根据参数查询所有可显示分类
   * @param listQuery  查询参数
   * @return
   */
  @Override
  public ObjectRestResponse<List<PositionTypeRespDTO>> listDisplayPositionType(
      PositionTypeListQueryReqDTO listQuery) {
    List<PositionTypeRespDTO> list = positionTypeManager.listDisplayPositionType(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  /**
   * 根据parentId查询数据,不分页
   * @param parentId  查询参数
   * @return
   */
  @Override
  public ObjectRestResponse<List<PositionTypeRespDTO>> listPositionTypeByParentId(Long parentId) {
    List<PositionTypeRespDTO> list = positionTypeManager.listPositionTypeByParentId(parentId);
    return new ObjectRestResponse<>().data(list);
  }

}
