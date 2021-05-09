package com.db.chaomaxs.userservice.manager.user;

import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackRespDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.service.user.UserTrackService;
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
