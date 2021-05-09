package com.github.xf717.userweb.manager.position;


import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionTypeListQueryReqDTO;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionTypeRespDTO;
import com.github.xf717.positionservice.rpc.positiontype.facade.PositionTypeRpcFacade;
import com.github.xf717.userweb.controller.position.vo.PositionTypeVO;
import com.github.xf717.userweb.convert.position.PositionTypeConvert;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * PositionTypeManager
 *
 * @author ding
 * @date 2021-04-06 17:45:09
 */
@Service
@Validated
public class PositionTypeManager {

  @Autowired
  private PositionTypeRpcFacade positionTypeRpcFacade;


  /**
   * 根据parentId查询数据,不分页
   *
   * @param parentId 查询参数
   * @return
   */
  public List<PositionTypeVO> listPositionTypeByParentId(Long parentId) {
    ObjectRestResponse<List<PositionTypeRespDTO>> objectRestResponse = positionTypeRpcFacade
        .listPositionTypeByParentId(parentId);
    objectRestResponse.checkError();
    return PositionTypeConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  public List<PositionTypeVO> queryPositionName(String positionName) {
    PositionTypeListQueryReqDTO positionTypeListQueryReqDTO = new PositionTypeListQueryReqDTO();
    positionTypeListQueryReqDTO.setTypeName(positionName);
    ObjectRestResponse<List<PositionTypeRespDTO>> listObjectRestResponse = positionTypeRpcFacade
        .listPositionTypes(positionTypeListQueryReqDTO);
    listObjectRestResponse.checkError();
    return PositionTypeConvert.INSTANCE.convertList(listObjectRestResponse.getData());
  }

}
