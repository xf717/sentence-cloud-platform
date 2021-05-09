package com.github.xf717.userservice.service.resume;

import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.userservice.convert.resume.UserResumeConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserResumeDO;
import com.github.xf717.userservice.dal.mysql.mapper.resume.UserResumeMapper;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.rpc.resume.dto.UserIdsReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserResumeService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserResumeService {

  @Autowired
  private UserResumeMapper userResumeMapper;


  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserResume(UserResumeCreateReqDTO createReqDTO) {
    return userResumeMapper.insert(UserResumeConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserResume(UserResumeUpdateReqDTO updateReqDTO) {
    UserResumeDO userResumeDO = userResumeMapper.selectById(updateReqDTO.getId());
    if (userResumeDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_RESUME.getCode());
    }
    userResumeDO = UserResumeConvert.INSTANCE.convert(updateReqDTO);
    int result = userResumeMapper.updateById(userResumeDO);
    return result;
  }


  /**
   * 根据id获取对象
   *
   * @param userId
   * @return
   */
  public UserResumeRespDTO getUserResumeById(Long userId) {
    UserResumeDO userResumeDO = userResumeMapper.selectByUserId(userId);
    if (userResumeDO == null) {
      return new UserResumeRespDTO();
    }
    return UserResumeConvert.INSTANCE.convert(userResumeDO);
  }

  /**
   * 根据用户ids 查找用户简历
   * @param  userDeliveryResumeReqDTO
   * @return
   */

  public List<UserResumeRespDTO> listResumeByUserIds(
      UserIdsReqDTO userDeliveryResumeReqDTO) {
    //根据用户ids 查找简历表
    List<UserResumeDO> userResumeList = userResumeMapper.selectByUserIds(
        userDeliveryResumeReqDTO.getUserIds());
    if (CollectionUtils.isEmpty(userResumeList)) {
      return Collections.emptyList();
    }
    return UserResumeConvert.INSTANCE.convertList(userResumeList);
  }

  
}
