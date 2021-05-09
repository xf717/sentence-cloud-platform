package com.db.chaomaxs.userservice.manager.user;

import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.service.user.UserInterviewService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserInterviewManager
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@Service
@Validated
public class UserInterviewManager {

    @Autowired
    private UserInterviewService userInterviewService;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveUserInterview(UserInterviewCreateReqDTO createReqDTO) {
        return userInterviewService.saveUserInterview(createReqDTO);
    }

    /**
     * 更新数据
     *
     * @param updateReqDTO
     * @return
     */
    public int updateUserInterview(UserInterviewUpdateReqDTO updateReqDTO) {
        return userInterviewService.updateUserInterview(updateReqDTO);
    }


    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    public UserInterviewRespDTO getUserInterviewById(Long id) {
        return userInterviewService.getUserInterviewById(id);
    }

    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<UserInterviewRespDTO> pageUserInterview(UserInterviewPageReqDTO page) {
        return userInterviewService.pageUserInterview(page);
    }


}
