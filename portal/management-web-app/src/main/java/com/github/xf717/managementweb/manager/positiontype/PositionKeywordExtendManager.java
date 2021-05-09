package com.github.xf717.managementweb.manager.positiontype;

import com.github.xf717.managementweb.controller.positiontype.dto.PositionKeywordExtendAddDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionKeywordExtendDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionKeywordExtendPageDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionKeywordExtendUpdateDTO;
import com.github.xf717.managementweb.controller.positiontype.vo.PositionKeywordExtendVO;
import com.github.xf717.managementweb.convert.positiontype.PositionKeywordExtendConvert;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionKeywordExtendRespDTO;
import com.github.xf717.positionservice.rpc.positiontype.facade.PositionKeywordExtendRpcFacade;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * PositionKeywordExtendManager
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Service
@Validated
public class PositionKeywordExtendManager {

  @Autowired
  private PositionKeywordExtendRpcFacade positionKeywordExtendRpcFacade;

  /**
   * 添加数据
   *
   * @param positionKeywordExtendCreateReqDTO 添加参数
   * @return
   */
  public int save(PositionKeywordExtendAddDTO positionKeywordExtendAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = positionKeywordExtendRpcFacade
        .save(PositionKeywordExtendConvert.INSTANCE.convert(positionKeywordExtendAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param positionKeywordExtendUpdateDTO 更新参数
   * @return
   */
  public int update(PositionKeywordExtendUpdateDTO positionKeywordExtendUpdateDTO) {
    BaseResponse baseResponse = positionKeywordExtendRpcFacade
        .update(PositionKeywordExtendConvert.INSTANCE.convert(positionKeywordExtendUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = positionKeywordExtendRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public PositionKeywordExtendVO getPositionKeywordExtendById(Long id) {
    ObjectRestResponse<PositionKeywordExtendRespDTO> objectRestResponse = positionKeywordExtendRpcFacade
        .getPositionKeywordExtendById(
            id);
    objectRestResponse.checkError();
    return PositionKeywordExtendConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param positionKeywordExtendDTO 查询参数
   * @return
   */
  public List<PositionKeywordExtendVO> listPositionKeywordExtends(
      PositionKeywordExtendDTO positionKeywordExtendDTO) {
    ObjectRestResponse<List<PositionKeywordExtendRespDTO>> objectRestResponse = positionKeywordExtendRpcFacade
        .listPositionKeywordExtends(
            PositionKeywordExtendConvert.INSTANCE.convert(positionKeywordExtendDTO));
    objectRestResponse.checkError();
    return PositionKeywordExtendConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<PositionKeywordExtendVO> pagePositionKeywordExtend(
      PositionKeywordExtendPageDTO pageReqDTO) {
    TableResultResponse<PositionKeywordExtendRespDTO> tableResultResponse = positionKeywordExtendRpcFacade
        .page(PositionKeywordExtendConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return PositionKeywordExtendConvert.INSTANCE.convert(tableResultResponse);
  }


}
