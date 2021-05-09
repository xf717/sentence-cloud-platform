package com.db.chaomaxs.userweb.manager.user;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserDeliveryRpcFacade;
import com.db.chaomaxs.userweb.controller.user.dto.UserDeliveryPageDTO;
import com.db.chaomaxs.userweb.controller.user.vo.UserPositionCollectVO;
import com.db.chaomaxs.userweb.convert.user.UserDeliveryConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserDeliveryManager
 *
 * @author momo
 * @date 2021-04-08 14:18:28
 */
@Service
@Validated
public class UserDeliveryManager {

  @Autowired
  private UserDeliveryRpcFacade userDeliveryRpcFacade;

  @Autowired
  private UserPositionCollectManager userPositionCollectManager;



  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<UserPositionCollectVO> pageUserDelivery(UserDeliveryPageDTO pageReqDTO) {
    UserDeliveryPageReqDTO userDeliveryPageReqDTO = UserDeliveryConvert.INSTANCE
        .convert(pageReqDTO);
    userDeliveryPageReqDTO.setUserId(BaseContextHandler.getUserId());
    TableResultResponse<UserDeliveryRespDTO> tableResultResponse = userDeliveryRpcFacade
        .page(userDeliveryPageReqDTO);
    tableResultResponse.checkError();
    TableResultResponse<UserPositionCollectVO> deliveryPage = UserDeliveryConvert.INSTANCE
        .convertPosition(tableResultResponse);
    if(!CollectionUtils.isEmpty(deliveryPage.getData().getRows())){
      deliveryPage =  userPositionCollectManager.positionInfo(deliveryPage);
    }
    return deliveryPage;
  }

}
