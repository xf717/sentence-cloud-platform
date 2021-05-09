package com.db.chaomaxs.userservice.manager.user;

import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.service.user.UserDeliveryService;

import java.util.List;

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
    private UserDeliveryService userDeliveryService;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveUserDelivery(UserDeliveryCreateReqDTO createReqDTO) {
        return userDeliveryService.saveUserDelivery(createReqDTO);
    }


    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<UserDeliveryRespDTO> pageUserDelivery(UserDeliveryPageReqDTO page) {
        return userDeliveryService.pageUserDelivery(page);
    }


}
