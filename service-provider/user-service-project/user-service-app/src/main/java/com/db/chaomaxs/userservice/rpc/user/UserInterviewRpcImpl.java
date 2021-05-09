package com.db.chaomaxs.userservice.rpc.user;

import com.db.chaomaxs.common.framework.exception.enums.GlobalErrorCodeConstants;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.manager.user.UserInterviewManager;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserInterviewRpcFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@Slf4j
@Service
public class UserInterviewRpcImpl implements UserInterviewRpcFacade {

    @Autowired
    private UserInterviewManager userInterviewManager;

    @Override
    public BaseResponse save(UserInterviewCreateReqDTO createReqDTO) {
        userInterviewManager.saveUserInterview(createReqDTO);
        return BaseResponse.success("保存成功");
    }

    @Override
    public BaseResponse update(UserInterviewUpdateReqDTO updateReqDTO) {
        userInterviewManager.updateUserInterview(updateReqDTO);
        return BaseResponse.success("更新成功");
    }


    @Override
    public ObjectRestResponse<UserInterviewRespDTO> getUserInterviewById(Long id) {
        UserInterviewRespDTO userInterview = userInterviewManager.getUserInterviewById(id);
        return new ObjectRestResponse<>().data(userInterview);
    }


    @Override
    public TableResultResponse<UserInterviewRespDTO> page(UserInterviewPageReqDTO pageReqDTO) {
        PageResult<UserInterviewRespDTO> pageResult = userInterviewManager.pageUserInterview(pageReqDTO);
        TableResultResponse<UserInterviewRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(), pageResult.getList());
        tableResultResponse.setCode(GlobalErrorCodeConstants.SUCCESS.getCode());
        return tableResultResponse;
    }

}
