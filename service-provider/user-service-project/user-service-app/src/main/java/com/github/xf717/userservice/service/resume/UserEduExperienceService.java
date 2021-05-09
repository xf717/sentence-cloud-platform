package com.github.xf717.userservice.service.resume;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.convert.resume.UserEduExperienceConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserEduExperienceDO;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserResumeDO;
import com.github.xf717.userservice.dal.mysql.mapper.resume.UserEduExperienceMapper;
import com.github.xf717.userservice.dal.mysql.mapper.resume.UserResumeMapper;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperiencePageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserEduExperienceService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserEduExperienceService {

  @Autowired
  private UserEduExperienceMapper userEduExperienceMapper;

  @Autowired
  private UserResumeMapper userResumeMapper;

  private static final int TEN = 10;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserEduExperience(UserEduExperienceCreateReqDTO createReqDTO) {

    UserResumeDO userResumeDO = userResumeMapper.selectByUserId(createReqDTO.getUserId());
    if (userResumeDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_RESUME.getCode());
    }
    List<UserEduExperienceDO> eduExperienceList = userEduExperienceMapper
        .listEduExperience(userResumeDO.getId());
    if (eduExperienceList.size() > TEN) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_EDUEXPERIENCE_MORE_THAN_TEN.getCode());
    }
    UserEduExperienceDO userEduExperienceDO = UserEduExperienceConvert.INSTANCE
        .convert(createReqDTO);
    userEduExperienceDO.setStartTime(DateUtil.parse(createReqDTO.getBeginTime(), "yyyy-MM"));
    userEduExperienceDO.setEndTime(DateUtil.parse(createReqDTO.getFinishTime(), "yyyy-MM"));
    userEduExperienceDO.setUserResumeId(userResumeDO.getId());
    return userEduExperienceMapper.insert(userEduExperienceDO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserEduExperience(UserEduExperienceUpdateReqDTO updateReqDTO) {
    UserEduExperienceDO userEduExperienceDO = userEduExperienceMapper
        .selectById(updateReqDTO.getId());
    if (userEduExperienceDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    userEduExperienceDO = UserEduExperienceConvert.INSTANCE.convert(updateReqDTO);
    userEduExperienceDO.setStartTime(DateUtil.parse(updateReqDTO.getBeginTime(), "yyyy-MM"));
    userEduExperienceDO.setEndTime(DateUtil.parse(updateReqDTO.getFinishTime(), "yyyy-MM"));
    int result = userEduExperienceMapper.updateById(userEduExperienceDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserEduExperience(Long id) {
    if (userEduExperienceMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userEduExperienceMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserEduExperienceRespDTO> listUserEduExperiences(
      UserEduExperienceListQueryReqDTO listQueryReqDTO) {
    List<UserEduExperienceDO> list = userEduExperienceMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserEduExperienceConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserEduExperienceRespDTO getUserEduExperienceById(Long id) {
    UserEduExperienceDO userEduExperienceDO = userEduExperienceMapper.selectById(id);
    if (userEduExperienceDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserEduExperienceConvert.INSTANCE.convert(userEduExperienceDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserEduExperienceRespDTO> pageUserEduExperience(
      UserEduExperiencePageReqDTO page) {
    IPage<UserEduExperienceDO> userEduExperiencePage = userEduExperienceMapper.selectPage(page);
    return UserEduExperienceConvert.INSTANCE.convertPage(userEduExperiencePage);
  }

  /**
   * 填写个人资料时返回上一步时根据用户id查询学历信息
   *
   * @param userId
   * @return
   */
  public UserEduExperienceRespDTO getLastStepByUserId(Long userId) {
    UserResumeDO userResumeDO = userResumeMapper.selectByUserId(userId);
    if (userResumeDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_RESUME.getCode());
    }
    UserEduExperienceDO eduExperienceDo = userEduExperienceMapper
        .selectEduExperience(userResumeDO.getId());
    return UserEduExperienceConvert.INSTANCE.convert(eduExperienceDo);
  }

  /**
   * 根据简历id 查询
   *
   * @param resumeId 简历id
   * @return
   */
  public List<UserEduExperienceRespDTO> listEduExperience(Long resumeId) {
    List<UserEduExperienceDO> userEduExperience = userEduExperienceMapper
        .listEduExperience(resumeId);
    if (CollectionUtils.isEmpty(userEduExperience)) {
      return Collections.emptyList();
    }
    return UserEduExperienceConvert.INSTANCE.convertList(userEduExperience);
  }


  /**
   * 根据简历ids 查询
   *
   * @param resumeIds 简历ids
   * @return
   */
  public List<UserEduExperienceRespDTO> listEduExperienceByResumeIds(List<Long> resumeIds) {
    List<UserEduExperienceDO> userEduExperienceList = userEduExperienceMapper
        .listEduExperienceByResumeIds(resumeIds);
    if (CollectionUtils.isEmpty(userEduExperienceList)) {
      return Collections.emptyList();
    }
    return UserEduExperienceConvert.INSTANCE.convertList(userEduExperienceList);
  }


  /**
   * 根据简历id获取最高学历
   *
   * @param resumeId
   * @return
   */
  public String selectEducation(Long resumeId) {
    return userEduExperienceMapper.selectEducation(resumeId);
  }

}
