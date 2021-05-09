package com.db.chaomaxs.companyweb.manager.position;

import com.db.chaomaxs.companyweb.controller.position.dto.UserPositionWantedAddDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.UserPositionWantedUpdateDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.UserPositionWantedDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.UserPositionWantedPageDTO;
import com.db.chaomaxs.companyweb.controller.position.vo.UserPositionWantedVO;
import com.db.chaomaxs.companyweb.convert.position.UserPositionWantedConvert;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.facade.UserPositionWantedRpcFacade;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserPositionWantedManager
 *
 * @author xiaofeng
 * @date 2021-03-29 16:36:57
 */
@Service
@Validated
public class UserPositionWantedManager {

  @Autowired
  private UserPositionWantedRpcFacade userPositionWantedRpcFacade;

  /**
   * 添加数据
   * @param userPositionWantedCreateReqDTO 添加参数
   * @return
   */
  public int save(UserPositionWantedAddDTO userPositionWantedAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = userPositionWantedRpcFacade
        .save(UserPositionWantedConvert.INSTANCE.convert(userPositionWantedAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   * @param userPositionWantedUpdateDTO  更新参数
   * @return
   */
  public int update(UserPositionWantedUpdateDTO userPositionWantedUpdateDTO) {
    BaseResponse baseResponse = userPositionWantedRpcFacade
        .update(UserPositionWantedConvert.INSTANCE.convert(userPositionWantedUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   * @param id  id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = userPositionWantedRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   * @param id id
   * @return
   */
  public UserPositionWantedVO getUserPositionWantedById(Long id) {
    ObjectRestResponse<UserPositionWantedRespDTO> objectRestResponse = userPositionWantedRpcFacade.getUserPositionWantedById(
        id);
    objectRestResponse.checkError();
    return UserPositionWantedConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   * @param userPositionWantedDTO  查询参数
   * @return
   */
  public List<UserPositionWantedVO> listUserPositionWanteds(UserPositionWantedDTO userPositionWantedDTO) {
    ObjectRestResponse<List<UserPositionWantedRespDTO>> objectRestResponse = userPositionWantedRpcFacade.listUserPositionWanteds(
                UserPositionWantedConvert.INSTANCE.convert(userPositionWantedDTO));
    objectRestResponse.checkError();
    return UserPositionWantedConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   * @param pageReqDTO  分页参数
   * @return
   */
  public TableResultResponse<UserPositionWantedVO> pageUserPositionWanted(UserPositionWantedPageDTO pageReqDTO) {
    TableResultResponse<UserPositionWantedRespDTO> tableResultResponse = userPositionWantedRpcFacade
        .page(UserPositionWantedConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return UserPositionWantedConvert.INSTANCE.convert(tableResultResponse);
  }


}
