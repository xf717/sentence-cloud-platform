package com.db.chaomaxs.userservice.service.user;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.userservice.convert.user.UserSetConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserSetDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserSetMapper;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.rpc.user.dto.UserSetCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserSetRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserSetUpdateReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserSetService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserSetService {

    @Autowired
    private UserSetMapper userSetMapper;

    /**
     * 保存数据
     *
     * @param userSetCreateReqDTO
     * @return
     */
    public int saveUserSet(UserSetCreateReqDTO userSetCreateReqDTO) {
        UserSetDO userSetDO = UserSetConvert.INSTANCE.convert(userSetCreateReqDTO);
        userSetDO.setUpdateBy(userSetCreateReqDTO.getUserId());
        userSetDO.setCreateBy(userSetCreateReqDTO.getUserId());
        return userSetMapper.insert(userSetDO);
    }

    /**
     * 更新数据
     *
     * @param updateReqDTO
     * @return
     */
    public int updateUserSet(UserSetUpdateReqDTO updateReqDTO) {
        UserSetDO userSetDO = userSetMapper.selectById(updateReqDTO.getId());
        if (userSetDO == null) {
            throw ServiceExceptionUtil.exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
        }
        userSetDO = UserSetConvert.INSTANCE.convert(updateReqDTO);
        userSetDO.setUpdateBy(updateReqDTO.getUserId());
        int result = userSetMapper.updateById(userSetDO);
        return result;
    }


    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    public UserSetRespDTO getUserSetById(Long id) {
        UserSetDO userSetDO = userSetMapper.selectById(id);
        if (userSetDO == null) {
            throw ServiceExceptionUtil.exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
        }
        return UserSetConvert.INSTANCE.convert(userSetDO);
    }


    public UserSetRespDTO getUserSetByUserIdAndCompanyUserId(Long userId, Long companyUserId) {
        UserSetDO userSetDO = userSetMapper.getUserSetByUserIdAndCompanyUserId(userId, companyUserId);
        return UserSetConvert.INSTANCE.convert(userSetDO);
    }
}
