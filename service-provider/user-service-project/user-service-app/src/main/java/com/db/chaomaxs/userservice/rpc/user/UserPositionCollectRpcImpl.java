package com.db.chaomaxs.userservice.rpc.user;

import com.db.chaomaxs.common.framework.exception.enums.GlobalErrorCodeConstants;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.manager.user.UserPositionCollectManager;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserPositionCollectRpcFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Slf4j
@Service
public class UserPositionCollectRpcImpl implements UserPositionCollectRpcFacade {

    @Autowired
    private UserPositionCollectManager userPositionCollectManager;

    @Override
    public BaseResponse save(UserPositionCollectCreateReqDTO createReqDTO) {
        userPositionCollectManager.saveUserPositionCollect(createReqDTO);
        return BaseResponse.success("保存成功");
    }


    @Override
    public BaseResponse remove(Long id) {
        userPositionCollectManager.deleteUserPositionCollect(id);
        return BaseResponse.success("删除成功");
    }

    @Override
    public ObjectRestResponse<UserPositionCollectRespDTO> getUserPositionCollectById(Long id) {
        UserPositionCollectRespDTO userPositionCollect = userPositionCollectManager.getUserPositionCollectById(id);
        return new ObjectRestResponse<>().data(userPositionCollect);
    }


    @Override
    public TableResultResponse<UserPositionCollectRespDTO> page(UserPositionCollectPageReqDTO pageReqDTO) {
        PageResult<UserPositionCollectRespDTO> pageResult = userPositionCollectManager.pageUserPositionCollect(pageReqDTO);
        TableResultResponse<UserPositionCollectRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(), pageResult.getList());
        tableResultResponse.setCode(GlobalErrorCodeConstants.SUCCESS.getCode());
        return tableResultResponse;
    }

}
