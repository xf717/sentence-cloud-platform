package com.github.xf717.userservice.manager.user;

import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.userservice.rpc.resume.dto.IdsReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserStatisticReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserStatisticRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackStatisticRespDTO;
import com.github.xf717.userservice.service.user.UserDeliveryService;
import com.github.xf717.userservice.service.user.UserInterviewService;
import com.github.xf717.userservice.service.user.UserPositionCollectService;
import com.github.xf717.userservice.service.user.UserTrackService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * CompanyUserInterviewManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class UserStatisticManager {
    @Autowired
    private UserTrackService userTrackService;

    @Autowired
    private UserInterviewService userInterviewService;

    @Autowired
    private UserPositionCollectService userPositionCollectService;

    @Autowired
    private UserDeliveryService userDeliveryService;


    public UserStatisticRespDTO getStatistic(UserStatisticReqDTO userStatisticReqDTO) {
        UserStatisticRespDTO userStatisticRespDTO = new UserStatisticRespDTO();
        userStatisticRespDTO.setTrackCount(userTrackService.count(userStatisticReqDTO));
        userStatisticRespDTO.setInterviewCount(userInterviewService.count(userStatisticReqDTO));
        userStatisticRespDTO.setCollectCount(userPositionCollectService.count(userStatisticReqDTO));
        userStatisticRespDTO.setDeliveryCount(userDeliveryService.count(userStatisticReqDTO));
        return userStatisticRespDTO;
    }

    public Map<Long, UserTrackStatisticRespDTO> getStatisticByPositionIds(IdsReqDTO idsReqDTO) {
        List<UserTrackStatisticRespDTO> list = userTrackService.getStatisticByPositionIds(idsReqDTO);
        if (CollectionUtils.isEmpty(list)) {
            return Maps.newHashMap();
        }
        return list.stream().collect(Collectors.toMap(UserTrackStatisticRespDTO::getPositionId, a -> a, (k1, k2) -> k2));
    }
}
