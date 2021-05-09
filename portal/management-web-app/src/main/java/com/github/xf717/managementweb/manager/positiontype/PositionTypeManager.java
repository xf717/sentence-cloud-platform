package com.github.xf717.managementweb.manager.positiontype;

import com.github.xf717.managementweb.controller.positiontype.dto.PositionTypeAddDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionTypeDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionTypePageDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionTypeUpdateDTO;
import com.github.xf717.managementweb.controller.positiontype.vo.PositionTypeVO;
import com.github.xf717.managementweb.convert.positiontype.PositionTypeConvert;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionTypeRespDTO;
import com.github.xf717.positionservice.rpc.positiontype.facade.PositionTypeRpcFacade;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * PositionTypeManager
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Service
@Validated
public class PositionTypeManager {

  @Autowired
  private PositionTypeRpcFacade positionTypeRpcFacade;

  /**
   * 添加数据
   * @param positionTypeCreateReqDTO 添加参数
   * @return
   */
  public int save(PositionTypeAddDTO positionTypeAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = positionTypeRpcFacade
        .save(PositionTypeConvert.INSTANCE.convert(positionTypeAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   * @param positionTypeUpdateDTO  更新参数
   * @return
   */
  public int update(PositionTypeUpdateDTO positionTypeUpdateDTO) {
    BaseResponse baseResponse = positionTypeRpcFacade
        .update(PositionTypeConvert.INSTANCE.convert(positionTypeUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   * @param id  id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = positionTypeRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   * @param id id
   * @return
   */
  public PositionTypeVO getPositionTypeById(Long id) {
    ObjectRestResponse<PositionTypeRespDTO> objectRestResponse = positionTypeRpcFacade.getPositionTypeById(
        id);
    objectRestResponse.checkError();
    return PositionTypeConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   * @param positionTypeDTO  查询参数
   * @return
   */
  public List<PositionTypeVO> listPositionTypes(PositionTypeDTO positionTypeDTO) {
    ObjectRestResponse<List<PositionTypeRespDTO>> objectRestResponse = positionTypeRpcFacade.listPositionTypes(
                PositionTypeConvert.INSTANCE.convert(positionTypeDTO));
    objectRestResponse.checkError();
    return PositionTypeConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   * @param pageReqDTO  分页参数
   * @return
   */
  public TableResultResponse<PositionTypeVO> pagePositionType(PositionTypePageDTO pageReqDTO) {
    TableResultResponse<PositionTypeRespDTO> tableResultResponse = positionTypeRpcFacade
        .page(PositionTypeConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return PositionTypeConvert.INSTANCE.convert(tableResultResponse);
  }


}
