package com.github.xf717.userweb.manager.user;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryRespDTO;
import com.github.xf717.userservice.rpc.user.facade.UserDeliveryRpcFacade;
import com.github.xf717.userweb.controller.user.dto.UserDeliveryPageDTO;
import com.github.xf717.userweb.controller.user.vo.UserPositionCollectVO;
import com.github.xf717.userweb.convert.user.UserDeliveryConvert;
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
