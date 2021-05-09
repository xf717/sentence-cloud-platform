package com.github.xf717.managementweb.manager.positiontype;

import com.github.xf717.managementweb.controller.positiontype.dto.PositionKeywordAddDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionKeywordDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionKeywordPageDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionKeywordUpdateDTO;
import com.github.xf717.managementweb.controller.positiontype.vo.PositionKeywordVO;
import com.github.xf717.managementweb.convert.positiontype.PositionKeywordConvert;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionKeywordRespDTO;
import com.github.xf717.positionservice.rpc.positiontype.facade.PositionKeywordRpcFacade;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * PositionKeywordManager
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Service
@Validated
public class PositionKeywordManager {

  @Autowired
  private PositionKeywordRpcFacade positionKeywordRpcFacade;

  /**
   * 添加数据
   * @param positionKeywordCreateReqDTO 添加参数
   * @return
   */
  public int save(PositionKeywordAddDTO positionKeywordAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = positionKeywordRpcFacade
        .save(PositionKeywordConvert.INSTANCE.convert(positionKeywordAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   * @param positionKeywordUpdateDTO  更新参数
   * @return
   */
  public int update(PositionKeywordUpdateDTO positionKeywordUpdateDTO) {
    BaseResponse baseResponse = positionKeywordRpcFacade
        .update(PositionKeywordConvert.INSTANCE.convert(positionKeywordUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   * @param id  id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = positionKeywordRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   * @param id id
   * @return
   */
  public PositionKeywordVO getPositionKeywordById(Long id) {
    ObjectRestResponse<PositionKeywordRespDTO> objectRestResponse = positionKeywordRpcFacade.getPositionKeywordById(
        id);
    objectRestResponse.checkError();
    return PositionKeywordConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   * @param positionKeywordDTO  查询参数
   * @return
   */
  public List<PositionKeywordVO> listPositionKeywords(PositionKeywordDTO positionKeywordDTO) {
    ObjectRestResponse<List<PositionKeywordRespDTO>> objectRestResponse = positionKeywordRpcFacade.listPositionKeywords(
                PositionKeywordConvert.INSTANCE.convert(positionKeywordDTO));
    objectRestResponse.checkError();
    return PositionKeywordConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   * @param pageReqDTO  分页参数
   * @return
   */
  public TableResultResponse<PositionKeywordVO> pagePositionKeyword(
      PositionKeywordPageDTO pageReqDTO) {
    TableResultResponse<PositionKeywordRespDTO> tableResultResponse = positionKeywordRpcFacade
        .page(PositionKeywordConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return PositionKeywordConvert.INSTANCE.convert(tableResultResponse);
  }


}
