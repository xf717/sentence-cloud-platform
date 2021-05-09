package com.github.xf717.userservice.rpc.user.facade.api;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userservice.rpc.resume.dto.IdsReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserStatisticReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserStatisticRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackStatisticRespDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 企业我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
public interface UserStatisticApi {


    /**
     * 根据Id查找
     *
     * @param userStatisticReqDTO
     * @return
     */
    @PostMapping("/facade/statistic")
    ObjectRestResponse<UserStatisticRespDTO> getStatistic(@RequestBody UserStatisticReqDTO userStatisticReqDTO);

    @PostMapping("/facade/statistic/getByPositionIds")
    Map<Long,UserTrackStatisticRespDTO> getStatisticByPositionIds(@RequestBody IdsReqDTO idsReqDTO);



}
