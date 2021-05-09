package com.db.chaomaxs.userservice.rpc.user;

import com.db.chaomaxs.common.framework.exception.enums.GlobalErrorCodeConstants;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.manager.user.UserDeliveryManager;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserDeliveryRpcFacade;
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
