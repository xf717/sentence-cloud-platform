package com.db.chaomaxs.userservice.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.user.UserDeliveryConvert;
import com.db.chaomaxs.userservice.convert.user.UserTrackConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserDeliveryDO;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserTrackDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserDeliveryMapper;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryUpdateReqDTO;

import java.util.Collections;
import java.util.List;

import com.db.chaomaxs.userservice.rpc.user.dto.UserStatisticReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserDeliveryService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserDeliveryService {

    @Autowired
    private UserDeliveryMapper userDeliveryMapper;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveUserDelivery(UserDeliveryCreateReqDTO createReqDTO) {
        UserDeliveryDO userDeliveryDO = UserDeliveryConvert.INSTANCE.convert(createReqDTO);
        UserDeliveryDO getUserDeliveryDO = userDeliveryMapper.getByUserIdAndCompanyUserId(userDeliveryDO);
        if (getUserDeliveryDO != null) {
            return 1;
        }
        return userDeliveryMapper.insert(userDeliveryDO);
    }

    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<UserDeliveryRespDTO> pageUserDelivery(UserDeliveryPageReqDTO page) {
        IPage<UserDeliveryDO> userDeliveryPage = userDeliveryMapper.selectPage(page);
        return UserDeliveryConvert.INSTANCE.convertPage(userDeliveryPage);
    }

    public Integer count(UserStatisticReqDTO userStatisticReqDTO) {
        return userDeliveryMapper.selectCount(userStatisticReqDTO);
    }
}
