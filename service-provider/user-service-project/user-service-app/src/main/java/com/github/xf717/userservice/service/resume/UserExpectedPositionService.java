package com.github.xf717.userservice.service.resume;

import com.github.xf717.common.framework.exception.ServiceException;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.userservice.convert.resume.UserExpectedPositionConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserExpectedPositionDO;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserExpectedPositionIndustryDO;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserResumeDO;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserExtendDO;
import com.github.xf717.userservice.dal.mysql.mapper.resume.UserExpectedPositionIndustryMapper;
import com.github.xf717.userservice.dal.mysql.mapper.resume.UserExpectedPositionMapper;
import com.github.xf717.userservice.dal.mysql.mapper.resume.UserResumeMapper;
import com.github.xf717.userservice.dal.mysql.mapper.user.UserExtendMapper;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedAndStatusRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionUpdateReqDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * UserExpectedPositionService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserExpectedPositionService {

  @Autowired
  private UserExpectedPositionMapper userExpectedPositionMapper;

  @Autowired
  private UserResumeMapper userResumeMapper;

  @Autowired
  private UserExpectedPositionIndustryMapper userExpectedPositionIndustryMapper;

  @Autowired
  private UserExtendMapper userExtendMapper;

  private static final int THREE = 3;

  private static final int ONE = 1;
  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  @Transactional(rollbackFor = ServiceException.class)
  public int saveUserExpectedPosition(UserExpectedPositionCreateReqDTO createReqDTO) {
    UserResumeDO userResumeDO = userResumeMapper.selectByUserId(createReqDTO.getUserId());
    if (userResumeDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_RESUME.getCode());
    }
    // 首次注册时更新个人求职状态
    if (createReqDTO.getPositionWantedDictionaryId() != null) {
      userResumeDO.setPositionWantedDictionaryId(createReqDTO.getPositionWantedDictionaryId());
      userResumeDO.setPositionWantedStatusName(createReqDTO.getPositionWantedStatusName());
      userResumeMapper.updateById(userResumeDO);
      UserExtendDO userExtendDO = userExtendMapper.selectByUserId(createReqDTO.getUserId());
      userExtendDO.setCompleteResume(ONE);
      userExtendMapper.updateById(userExtendDO);
    }
    List<UserExpectedPositionDO> userExpectedPositionList = userExpectedPositionMapper
        .listExpectedPosition(userResumeDO.getId());
    if (userExpectedPositionList.size() >= THREE) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_EXPECTED_POSITION_MORE_THAN_THREE.getCode());
    }
    UserExpectedPositionDO userExpectedPositionDO = UserExpectedPositionConvert.INSTANCE
        .convert(createReqDTO);
    userExpectedPositionDO.setUserResumeId(userResumeDO.getId());
    userExpectedPositionMapper.insert(userExpectedPositionDO);
    UserExpectedPositionIndustryDO industryDO = null;
    List<UserExpectedPositionIndustryDO> industryList = new ArrayList<>();
    for (UserExpectedPositionIndustryCreateReqDTO dto : createReqDTO.getExpectedPositionIndustryList()) {
      industryDO = new UserExpectedPositionIndustryDO()
          .setExpectedPositionId(userExpectedPositionDO.getId()).setIndustryId(dto.getIndustryId())
          .setIndustryName(dto.getIndustryName());
      industryList.add(industryDO);
    }
    int result = userExpectedPositionIndustryMapper.batchInsert(industryList);
    return result;
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  @Transactional(rollbackFor = ServiceException.class)
  public int updateUserExpectedPosition(UserExpectedPositionUpdateReqDTO updateReqDTO) {
    UserExpectedPositionDO userExpectedPositionDO = userExpectedPositionMapper
        .selectById(updateReqDTO.getId());
    if (userExpectedPositionDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_EXPECTED_POSITION_NOT_EXISTS.getCode());
    }
    //根据求职期望id 删除期望行业数据
    userExpectedPositionIndustryMapper.deleteByExpectedPositionId(updateReqDTO.getId());
    //根据求职期望id 新建期望行业数据
    UserExpectedPositionIndustryDO industryDO = null;
    List<UserExpectedPositionIndustryDO> industryList = new ArrayList<>();
    for (UserExpectedPositionIndustryUpdateReqDTO dto : updateReqDTO.getExpectedPositionIndustryList()) {
      industryDO = new UserExpectedPositionIndustryDO()
          .setExpectedPositionId(userExpectedPositionDO.getId()).setIndustryId(dto.getIndustryId())
          .setIndustryName(dto.getIndustryName());
      industryList.add(industryDO);
    }
    userExpectedPositionIndustryMapper.batchInsert(industryList);
    userExpectedPositionDO = UserExpectedPositionConvert.INSTANCE.convert(updateReqDTO);
    int result = userExpectedPositionMapper.updateById(userExpectedPositionDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserExpectedPosition(Long id) {
    if (userExpectedPositionMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_EXPECTED_POSITION_NOT_EXISTS.getCode());
    }
    //根据求职期望id 删除期望行业数据
    userExpectedPositionIndustryMapper.deleteByExpectedPositionId(id);
    int result = userExpectedPositionMapper.deleteById(id);
    return result;
  }


  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserExpectedPositionDO getUserExpectedPositionById(Long id) {
    UserExpectedPositionDO userExpectedPositionDO = userExpectedPositionMapper.selectById(id);
    if (userExpectedPositionDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_EXPECTED_POSITION_NOT_EXISTS.getCode());
    }

    return userExpectedPositionDO;
  }


  /**
   * 根据用户id 查询求职期望和当前在职状态
   *
   * @param userId
   * @return
   */
  public UserExpectedAndStatusRespDTO getUserExpectedAndStatusByUserId(Long userId) {
    UserExpectedAndStatusRespDTO userExpectedAndStatusRespDTO = new UserExpectedAndStatusRespDTO();
    UserResumeDO userResumeDO = userResumeMapper.selectByUserId(userId);
    if (null == userResumeDO) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_RESUME.getCode());
    }
    List<UserExpectedPositionDO> userExpectedPositionList = userExpectedPositionMapper
        .listExpectedPosition(userResumeDO.getId());
    userExpectedAndStatusRespDTO.setUserExpectedPositionVOList(UserExpectedPositionConvert.INSTANCE
        .convertList(userExpectedPositionList));
    userExpectedAndStatusRespDTO.setUserResumeId(userResumeDO.getId());
    userExpectedAndStatusRespDTO
        .setPositionWantedDictionaryId(userResumeDO.getPositionWantedDictionaryId());
    userExpectedAndStatusRespDTO
        .setPositionWantedStatusName(userResumeDO.getPositionWantedStatusName());
    return userExpectedAndStatusRespDTO;
  }

  /**
   * 根据简历id 查询
   * @param resumeId 简历id
   * @return
   */
  public List<UserExpectedPositionRespDTO> listExpectedPosition(Long resumeId) {
    List<UserExpectedPositionDO> userExpectedPosition = userExpectedPositionMapper
        .listExpectedPosition(resumeId);
    if (CollectionUtils.isEmpty(userExpectedPosition)) {
      return Collections.emptyList();
    }
    return UserExpectedPositionConvert.INSTANCE.convertList(userExpectedPosition);
  }

  /**
   * 根据简历ids 查询
   * @param resumeIds 简历ids
   * @return
   */
  public List<UserExpectedPositionRespDTO> listExpectedPositionByresumeIds(List<Long> resumeIds) {
    List<UserExpectedPositionDO> userExpectedPosition = userExpectedPositionMapper
        .listExpectedPositionByresumeIds(resumeIds);
    if (CollectionUtils.isEmpty(userExpectedPosition)) {
      return Collections.emptyList();
    }
    return UserExpectedPositionConvert.INSTANCE.convertList(userExpectedPosition);
  }

}
