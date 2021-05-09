package com.db.chaomaxs.userservice.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.user.UserTrackConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserTrackDO;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserTrackStatisticsDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserTrackMapper;
import com.db.chaomaxs.userservice.rpc.resume.dto.IdsReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserStatisticReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackStatisticRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * UserTrackService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserTrackService {

    @Autowired
    private UserTrackMapper userTrackMapper;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveUserTrack(UserTrackCreateReqDTO createReqDTO) {
        UserTrackDO userTrackDO = UserTrackConvert.INSTANCE.convert(createReqDTO);
        UserTrackDO getUserTrackDO = userTrackMapper.getByUserIdAndCompanyUserId(userTrackDO);
        //判断是否已经有足迹，有足迹修改时间
        if (getUserTrackDO != null) {
            return userTrackMapper.updateById(getUserTrackDO.getId());
        }
        return userTrackMapper.insert(userTrackDO);
    }


    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<UserTrackRespDTO> pageUserTrack(UserTrackPageReqDTO page) {
        IPage<UserTrackDO> userTrackPage = userTrackMapper.selectPage(page);
        return UserTrackConvert.INSTANCE.convertPage(userTrackPage);
    }

    public Integer count(UserStatisticReqDTO userStatisticReqDTO) {
        return userTrackMapper.selectCount(userStatisticReqDTO);
    }

    public List<UserTrackStatisticRespDTO> getStatisticByPositionIds(IdsReqDTO idsReqDTO) {
        List<UserTrackStatisticsDO> userTrackStatisticsDOList = userTrackMapper.getStatisticByPositionIds(idsReqDTO.getIds());
        return UserTrackConvert.INSTANCE.convertStatistic(userTrackStatisticsDOList);
    }
}
