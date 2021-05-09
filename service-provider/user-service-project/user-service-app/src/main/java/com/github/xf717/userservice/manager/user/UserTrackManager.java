package com.github.xf717.userservice.manager.user;

import com.github.xf717.userservice.rpc.user.dto.UserPositionRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackRespDTO;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.service.user.UserTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserTrackManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Service
@Validated
public class UserTrackManager {

    @Autowired
    private UserTrackService userTrackService;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveUserTrack(UserTrackCreateReqDTO createReqDTO) {
        return userTrackService.saveUserTrack(createReqDTO);
    }


    /**
     * 我的足迹
     *
     * @param page
     * @return
     */
    public PageResult<UserTrackRespDTO> pageUserTrack(UserTrackPageReqDTO page) {
        return userTrackService.pageUserTrack(page);
    }


}
