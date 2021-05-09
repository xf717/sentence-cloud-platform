package com.db.chaomaxs.userservice.manager.user;

import com.db.chaomaxs.userservice.rpc.user.dto.UserSetCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserSetRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserSetUpdateReqDTO;
import com.db.chaomaxs.userservice.service.user.UserSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserSetManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Service
@Validated
public class UserSetManager {

    @Autowired
    private UserSetService userSetService;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveUserSet(UserSetCreateReqDTO createReqDTO) {
        return userSetService.saveUserSet(createReqDTO);
    }

    /**
     * 更新数据
     *
     * @param updateReqDTO
     * @return
     */
    public int updateUserSet(UserSetUpdateReqDTO updateReqDTO) {
        return userSetService.updateUserSet(updateReqDTO);
    }

    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    public UserSetRespDTO getUserSetById(Long id) {
        return userSetService.getUserSetById(id);
    }

    public UserSetRespDTO getUserSetByUserIdAndCompanyUserId(Long userId, Long companyUserId) {
        return userSetService.getUserSetByUserIdAndCompanyUserId(userId, companyUserId);
    }
}
