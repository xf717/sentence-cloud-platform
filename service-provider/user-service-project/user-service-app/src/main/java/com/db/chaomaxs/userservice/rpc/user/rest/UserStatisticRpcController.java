package com.db.chaomaxs.userservice.rpc.user.rest;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userservice.rpc.resume.dto.IdsReqDTO;
import com.db.chaomaxs.userservice.rpc.user.UserStatisticRpcImpl;
import com.db.chaomaxs.userservice.rpc.user.dto.UserStatisticReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserStatisticRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackStatisticRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.api.UserStatisticApi;
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
