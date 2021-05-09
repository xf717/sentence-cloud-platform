package com.github.xf717.userservice.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.convert.user.UserDeliveryConvert;
import com.github.xf717.userservice.convert.user.UserTrackConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserDeliveryDO;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserTrackDO;
import com.github.xf717.userservice.dal.mysql.mapper.user.UserDeliveryMapper;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryUpdateReqDTO;

import java.util.Collections;
import java.util.List;

import com.github.xf717.userservice.rpc.user.dto.UserStatisticReqDTO;
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
