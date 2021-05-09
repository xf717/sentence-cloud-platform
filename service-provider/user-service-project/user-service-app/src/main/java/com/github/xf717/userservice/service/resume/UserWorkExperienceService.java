package com.github.xf717.userservice.service.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.ServiceException;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.convert.resume.UserWorkExperienceConvert;
import com.github.xf717.userservice.convert.resume.UserWorkSkillTagConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserResumeDO;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserWorkExperienceDO;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserWorkSkillTagDO;
import com.github.xf717.userservice.dal.mysql.mapper.resume.UserResumeMapper;
import com.github.xf717.userservice.dal.mysql.mapper.resume.UserWorkExperienceMapper;
import com.github.xf717.userservice.dal.mysql.mapper.resume.UserWorkSkillTagMapper;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperiencePageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceUpdateReqDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * UserWorkExperienceService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserWorkExperienceService {

  @Autowired
  private UserWorkExperienceMapper userWorkExperienceMapper;

  @Autowired
  private UserWorkSkillTagMapper userWorkSkillTagMapper;

  @Autowired
  private UserResumeMapper userResumeMapper;

  private static final int TEN = 10;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  @Transactional(rollbackFor = ServiceException.class)
  public int saveUserWorkExperience(UserWorkExperienceCreateReqDTO createReqDTO) {
    UserResumeDO userResumeDO = userResumeMapper.selectByUserId(createReqDTO.getUserId());
    if (userResumeDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_RESUME.getCode());
    }
    List<UserWorkExperienceDO> userWorkExperienceList = userWorkExperienceMapper
        .listWorkExperience(userResumeDO.getId());
    if (userWorkExperienceList.size() >= TEN) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_WORK_EXPERIENCE_MORE_THAN_TEN.getCode());
    }
    UserWorkExperienceDO userWorkExperienceDO = UserWorkExperienceConvert.INSTANCE
        .convert(createReqDTO);
    userWorkExperienceDO.setUserResumeId(userResumeDO.getId());
    int result = userWorkExperienceMapper.insert(userWorkExperienceDO);
    // 添加到技能标签表
    List<UserWorkSkillTagDO> tagList = new ArrayList<>();
    UserWorkSkillTagDO userWorkSkillTagDO = null;
    for (String tag : createReqDTO.getWorkSkillTagList()) {
      userWorkSkillTagDO = new UserWorkSkillTagDO().setSkillTag(tag)
          .setWorkExperienceId(userWorkExperienceDO.getId());
      tagList.add(userWorkSkillTagDO);
    }
    userWorkSkillTagMapper.batchInsert(tagList);
    return result;
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  @Transactional(rollbackFor = ServiceException.class)
  public int updateUserWorkExperience(UserWorkExperienceUpdateReqDTO updateReqDTO) {
    UserWorkExperienceDO userWorkExperienceDO = userWorkExperienceMapper
        .selectById(updateReqDTO.getId());
    if (userWorkExperienceDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    userWorkExperienceDO = UserWorkExperienceConvert.INSTANCE.convert(updateReqDTO);
    // 根据工作经历id 删除工作标签
    userWorkSkillTagMapper.deleteByWorkExperience(userWorkExperienceDO.getId());
    //批量添加工作标签
    if(!CollectionUtils.isEmpty(updateReqDTO.getWorkSkillTagUpdateReqList())){
      List<UserWorkSkillTagDO> workSkillTagList = new ArrayList<>();
      UserWorkSkillTagDO userWorkSkillTagDO = null;
      for(String tag : updateReqDTO.getWorkSkillTagUpdateReqList()){
        userWorkSkillTagDO = new UserWorkSkillTagDO().setSkillTag(tag).setWorkExperienceId(updateReqDTO.getId());
        workSkillTagList.add(userWorkSkillTagDO);
      }
      userWorkSkillTagMapper.batchInsert(workSkillTagList);
    }
    int result = userWorkExperienceMapper.updateById(userWorkExperienceDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserWorkExperience(Long id) {
    if (userWorkExperienceMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userWorkExperienceMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserWorkExperienceRespDTO> listUserWorkExperiences(
      UserWorkExperienceListQueryReqDTO listQueryReqDTO) {
    List<UserWorkExperienceDO> list = userWorkExperienceMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserWorkExperienceConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserWorkExperienceRespDTO getUserWorkExperienceById(Long id) {
    UserWorkExperienceDO userWorkExperienceDO = userWorkExperienceMapper.selectById(id);
    if (userWorkExperienceDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_WORK_EXPERIENCE_NOT_EXISTS.getCode());
    }
    List<UserWorkSkillTagDO> workSkillTagList = userWorkSkillTagMapper
        .listByWorkExperienceId(id);
    UserWorkExperienceRespDTO resp = UserWorkExperienceConvert.INSTANCE
        .convert(userWorkExperienceDO);
    resp.setWorkSkillTagList(UserWorkSkillTagConvert.INSTANCE.convertList(workSkillTagList));
    return resp;
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserWorkExperienceRespDTO> pageUserWorkExperience(
      UserWorkExperiencePageReqDTO page) {
    IPage<UserWorkExperienceDO> userWorkExperiencePage = userWorkExperienceMapper.selectPage(page);
    return UserWorkExperienceConvert.INSTANCE.convertPage(userWorkExperiencePage);
  }

  /**
   * 填写资料查询工作经历信息
   * @param userId
   * @return
   */
  public UserWorkExperienceRespDTO getLastStepByUserId(Long userId) {
    UserResumeDO userResumeDO = userResumeMapper.selectByUserId(userId);
    if (userResumeDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_RESUME.getCode());
    }
    List<UserWorkExperienceDO> userWorkExperienceList = userWorkExperienceMapper
        .listWorkExperience(userResumeDO.getId());
    Optional<UserWorkExperienceDO> workExperience = userWorkExperienceList.stream().findFirst();
    if(!workExperience.isPresent()){
      return null;
    }
    UserWorkExperienceDO userWorkExperienceDO = workExperience.get();
    UserWorkExperienceRespDTO resp = UserWorkExperienceConvert.INSTANCE
        .convert(userWorkExperienceDO);
    List<UserWorkSkillTagDO> workSkillTagList = userWorkSkillTagMapper
        .listByWorkExperienceId(userWorkExperienceDO.getId());
    resp.setWorkSkillTagList(UserWorkSkillTagConvert.INSTANCE.convertList(workSkillTagList));
    return resp;
  }

  /**
   * 根据简历id 查询
   * @param resumeId 简历id
   * @return
   */
  public List<UserWorkExperienceRespDTO> listWorkExperience(Long resumeId) {
    List<UserWorkExperienceDO> list = userWorkExperienceMapper.listWorkExperience(resumeId);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserWorkExperienceConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据简历ids 查询
   * @param resumeIds 简历ids
   * @return
   */
  public List<UserWorkExperienceRespDTO> listWorkExperienceByResumeIds(List<Long> resumeIds) {
    List<UserWorkExperienceDO> userWorkExperience = userWorkExperienceMapper
        .listWorkExperienceByResumeIds(resumeIds);
    if (CollectionUtils.isEmpty(userWorkExperience)) {
      return Collections.emptyList();
    }
    return UserWorkExperienceConvert.INSTANCE.convertList(userWorkExperience);
  }

}
