package com.github.xf717.userservice.rpc.user.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.UserDeliveryRpcImpl;
import com.github.xf717.userservice.rpc.user.facade.api.UserDeliveryApi;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryPageReqDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业投递表
 *
 * @author momo
 * @date 2021-04-08 14:18:28
 */
@RestController
public class UserDeliveryRpcController implements UserDeliveryApi {

    @Autowired
    private UserDeliveryRpcImpl userDeliveryRpc;

    @Override
    public BaseResponse save(@RequestBody UserDeliveryCreateReqDTO createReqDTO) {
        return userDeliveryRpc.save(createReqDTO);
    }

    @Override
    public TableResultResponse<UserDeliveryRespDTO> page(@RequestBody UserDeliveryPageReqDTO pageReqDTO) {
        return userDeliveryRpc.page(pageReqDTO);
    }
}
