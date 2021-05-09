package com.github.xf717.userservice.rpc.user;

import com.github.xf717.common.framework.exception.enums.GlobalErrorCodeConstants;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.manager.user.UserDeliveryManager;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryRespDTO;
import com.github.xf717.userservice.rpc.user.facade.UserDeliveryRpcFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author momo
 * @date 2021-04-08 14:18:28
 */
@Slf4j
@Service
public class UserDeliveryRpcImpl implements UserDeliveryRpcFacade {

    @Autowired
    private UserDeliveryManager userDeliveryManager;

    @Override
    public BaseResponse save(UserDeliveryCreateReqDTO createReqDTO) {
        userDeliveryManager.saveUserDelivery(createReqDTO);
        return BaseResponse.success("保存成功");
    }

    @Override
    public TableResultResponse<UserDeliveryRespDTO> page(UserDeliveryPageReqDTO pageReqDTO) {
        PageResult<UserDeliveryRespDTO> pageResult = userDeliveryManager.pageUserDelivery(pageReqDTO);
        TableResultResponse<UserDeliveryRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(), pageResult.getList());
        tableResultResponse.setCode(GlobalErrorCodeConstants.SUCCESS.getCode());
        return tableResultResponse;
    }

}
