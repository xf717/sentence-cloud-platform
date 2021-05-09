package com.github.xf717.userservice.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.convert.user.UserPositionCollectConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserPositionCollectDO;
import com.github.xf717.userservice.dal.mysql.mapper.user.UserPositionCollectMapper;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.rpc.user.dto.UserPositionCollectCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPositionCollectPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPositionCollectRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserStatisticReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserPositionCollectService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserPositionCollectService {

    @Autowired
    private UserPositionCollectMapper userPositionCollectMapper;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveUserPositionCollect(UserPositionCollectCreateReqDTO createReqDTO) {
        UserPositionCollectDO userPositionCollectDO = UserPositionCollectConvert.INSTANCE.convert(createReqDTO);
        UserPositionCollectDO getUserPositionCollectDO = userPositionCollectMapper.getByUserIdAndCompanyUserId(userPositionCollectDO);
        if (getUserPositionCollectDO != null) {
            return 1;
        }
        return userPositionCollectMapper.insert(userPositionCollectDO);
    }


    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    public int deleteUserPositionCollect(Long id) {
        if (userPositionCollectMapper.selectById(id) == null) {
            throw ServiceExceptionUtil.exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
        }
        int result = userPositionCollectMapper.deleteById(id);
        return result;
    }


    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    public UserPositionCollectRespDTO getUserPositionCollectById(Long id) {
        UserPositionCollectDO userPositionCollectDO = userPositionCollectMapper.selectById(id);
        if (userPositionCollectDO == null) {
            throw ServiceExceptionUtil.exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
        }
        return UserPositionCollectConvert.INSTANCE.convert(userPositionCollectDO);
    }

    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<UserPositionCollectRespDTO> pageUserPositionCollect(UserPositionCollectPageReqDTO page) {
        IPage<UserPositionCollectDO> userPositionCollectPage = userPositionCollectMapper.selectPage(page);
        return UserPositionCollectConvert.INSTANCE.convertPage(userPositionCollectPage);
    }


    public Integer count(UserStatisticReqDTO userStatisticReqDTO) {
        return userPositionCollectMapper.selectCount(userStatisticReqDTO);
    }
}
