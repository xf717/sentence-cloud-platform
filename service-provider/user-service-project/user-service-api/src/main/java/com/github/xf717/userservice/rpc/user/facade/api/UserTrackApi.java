package com.github.xf717.userservice.rpc.user.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserPositionRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackPageReqDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
public interface UserTrackApi {

    /**
     * 添加数据
     *
     * @param createReqDTO 添加参数
     * @return
     */
    @PostMapping("/facade/userTrack/save")
    BaseResponse save(@RequestBody UserTrackCreateReqDTO createReqDTO);

    /**
     * 查找数据显示分页
     *
     * @param pageReqDTO 分页参数
     * @return
     */
    @PostMapping("/facade/userTrack/page")
    TableResultResponse<UserTrackRespDTO> page(@RequestBody UserTrackPageReqDTO pageReqDTO);
}
