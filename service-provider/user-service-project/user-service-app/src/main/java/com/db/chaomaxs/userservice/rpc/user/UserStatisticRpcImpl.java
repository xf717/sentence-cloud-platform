package com.db.chaomaxs.userservice.rpc.user;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userservice.manager.user.UserStatisticManager;
import com.db.chaomaxs.userservice.rpc.resume.dto.IdsReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserStatisticReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserStatisticRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackStatisticRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserStatisticRpcFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @data 2021-03-26 10:18:33
 */
@Slf4j
@Service
public class UserStatisticRpcImpl implements UserStatisticRpcFacade {

    @Autowired
    private UserStatisticManager userStatisticManager;


    @Override
    public ObjectRestResponse<UserStatisticRespDTO> getStatistic(UserStatisticReqDTO userStatisticReqDTO) {
        return new ObjectRestResponse<>().data(userStatisticManager.getStatistic(userStatisticReqDTO));
    }

    @Override
    public Map<Long,UserTrackStatisticRespDTO> getStatisticByPositionIds(IdsReqDTO idsReqDTO) {
        return userStatisticManager.getStatisticByPositionIds(idsReqDTO);
    }
}
