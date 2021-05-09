package com.db.chaomaxs.managementweb.manager.auth;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupLeaderAddDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupLeaderDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupLeaderPageDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupLeaderUpdateDTO;
import com.db.chaomaxs.managementweb.controller.auth.vo.BaseGroupLeaderVO;
import com.db.chaomaxs.managementweb.convert.auth.BaseGroupLeaderConvert;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.facade.BaseGroupLeaderRpcFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * BaseGroupLeaderManager
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Service
@Validated
public class BaseGroupLeaderManager {

  @Autowired
  private BaseGroupLeaderRpcFacade baseGroupLeaderRpcFacade;

  /**
   * 添加数据
   *
   * @param baseGroupLeaderAddDTO 添加参数
   * @return
   */
  public int save(BaseGroupLeaderAddDTO baseGroupLeaderAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = baseGroupLeaderRpcFacade
        .save(BaseGroupLeaderConvert.INSTANCE.convert(baseGroupLeaderAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param baseGroupLeaderUpdateDTO 更新参数
   * @return
   */
  public int update(BaseGroupLeaderUpdateDTO baseGroupLeaderUpdateDTO) {
    BaseResponse baseResponse = baseGroupLeaderRpcFacade
        .update(BaseGroupLeaderConvert.INSTANCE.convert(baseGroupLeaderUpdateDTO));
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
    BaseResponse baseResponse = baseGroupLeaderRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public BaseGroupLeaderVO getBaseGroupLeaderById(Long id) {
    ObjectRestResponse<BaseGroupLeaderRespDTO> objectRestResponse = baseGroupLeaderRpcFacade
        .getBaseGroupLeaderById(id);
    objectRestResponse.checkError();
    return BaseGroupLeaderConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param baseGroupLeaderDTO 查询参数
   * @return
   */
  public List<BaseGroupLeaderVO> listBaseGroupLeaders(BaseGroupLeaderDTO baseGroupLeaderDTO) {
    ObjectRestResponse<List<BaseGroupLeaderRespDTO>> objectRestResponse = baseGroupLeaderRpcFacade
        .listBaseGroupLeaders(BaseGroupLeaderConvert.INSTANCE.convert(baseGroupLeaderDTO));
    objectRestResponse.checkError();
    return BaseGroupLeaderConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageDTO 分页参数
   * @return
   */
  public TableResultResponse<BaseGroupLeaderVO> pageBaseGroupLeader(
      BaseGroupLeaderPageDTO pageDTO) {
    TableResultResponse<BaseGroupLeaderRespDTO> tableResultResponse = baseGroupLeaderRpcFacade
        .page(BaseGroupLeaderConvert.INSTANCE.convert(pageDTO));
    tableResultResponse.checkError();
    return BaseGroupLeaderConvert.INSTANCE.convert(tableResultResponse);
  }


}
