package com.db.chaomaxs.userservice.manager.user;

import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectRespDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.service.user.UserPositionCollectService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserPositionCollectManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Service
@Validated
public class UserPositionCollectManager {

    @Autowired
    private UserPositionCollectService userPositionCollectService;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveUserPositionCollect(UserPositionCollectCreateReqDTO createReqDTO) {
        return userPositionCollectService.saveUserPositionCollect(createReqDTO);
    }


    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    public int deleteUserPositionCollect(Long id) {
        return userPositionCollectService.deleteUserPositionCollect(id);
    }
    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    public UserPositionCollectRespDTO getUserPositionCollectById(Long id) {
        return userPositionCollectService.getUserPositionCollectById(id);
    }
    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<UserPositionCollectRespDTO> pageUserPositionCollect(UserPositionCollectPageReqDTO page) {
        return userPositionCollectService.pageUserPositionCollect(page);
    }


}
