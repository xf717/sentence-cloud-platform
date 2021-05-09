package com.github.xf717.userservice.rpc.user.rest;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userservice.rpc.resume.dto.IdsReqDTO;
import com.github.xf717.userservice.rpc.user.UserStatisticRpcImpl;
import com.github.xf717.userservice.rpc.user.dto.UserStatisticReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserStatisticRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackStatisticRespDTO;
import com.github.xf717.userservice.rpc.user.facade.api.UserStatisticApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 企业我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@RestController
public class UserStatisticRpcController implements UserStatisticApi {

    @Autowired
    private UserStatisticRpcImpl userStatisticRpc;

    @Override
    public ObjectRestResponse<UserStatisticRespDTO> getStatistic(@RequestBody UserStatisticReqDTO userStatisticReqDTO) {
        return userStatisticRpc.getStatistic(userStatisticReqDTO);
    }

    @Override
    public Map<Long,UserTrackStatisticRespDTO> getStatisticByPositionIds(IdsReqDTO idsReqDTO) {
        return userStatisticRpc.getStatisticByPositionIds(idsReqDTO);
    }
}
