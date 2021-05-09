package com.github.xf717.userservice.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.convert.user.UserInterviewConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserInterviewDO;
import com.github.xf717.userservice.dal.mysql.mapper.user.UserInterviewMapper;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserStatisticReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserInterviewService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserInterviewService {

    @Autowired
    private UserInterviewMapper userInterviewMapper;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveUserInterview(UserInterviewCreateReqDTO createReqDTO) {
        return userInterviewMapper.insert(UserInterviewConvert.INSTANCE.convert(createReqDTO));
    }

    /**
     * 更新数据
     *
     * @param updateReqDTO
     * @return
     */
    public int updateUserInterview(UserInterviewUpdateReqDTO updateReqDTO) {
        UserInterviewDO userInterviewDO = userInterviewMapper.selectById(updateReqDTO.getId());
        if (userInterviewDO == null) {
            throw ServiceExceptionUtil.exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
        }
        userInterviewDO = UserInterviewConvert.INSTANCE.convert(updateReqDTO);
        int result = userInterviewMapper.updateById(userInterviewDO);
        return result;
    }


    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    public UserInterviewRespDTO getUserInterviewById(Long id) {
        UserInterviewDO userInterviewDO = userInterviewMapper.selectById(id);
        if (userInterviewDO == null) {
            throw ServiceExceptionUtil.exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
        }
        return UserInterviewConvert.INSTANCE.convert(userInterviewDO);
    }

    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<UserInterviewRespDTO> pageUserInterview(UserInterviewPageReqDTO page) {
        IPage<UserInterviewDO> userInterviewPage = userInterviewMapper.selectPage(page);
        return UserInterviewConvert.INSTANCE.convertPage(userInterviewPage);
    }


    public Integer count(UserStatisticReqDTO userStatisticReqDTO) {
        return userInterviewMapper.selectCount(userStatisticReqDTO);
    }
}
