package com.github.xf717.userservice.manager.resume;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserIdsReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeDetailRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProjectExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkSkillTagRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPersonalInfoRespDTO;
import com.github.xf717.userservice.service.resume.UserCredentialService;
import com.github.xf717.userservice.service.resume.UserEduExperienceService;
import com.github.xf717.userservice.service.resume.UserExpectedPositionService;
import com.github.xf717.userservice.service.resume.UserProfessionalSkillService;
import com.github.xf717.userservice.service.resume.UserProjectExperienceService;
import com.github.xf717.userservice.service.resume.UserResumeService;
import com.github.xf717.userservice.service.resume.UserWorkExperienceService;
import com.github.xf717.userservice.service.resume.UserWorkSkillTagService;
import com.github.xf717.userservice.service.user.UserExtendService;
import com.github.xf717.userservice.service.user.UserInfoService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserResumeManager
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Service
@Validated
public class UserResumeManager {

  @Autowired
  private UserResumeService userResumeService;

  @Autowired
  private UserProjectExperienceService userProjectExperienceService;

  @Autowired
  private UserWorkExperienceService userWorkExperienceService;

  @Autowired
  private UserProfessionalSkillService userProfessionalSkillService;

  @Autowired
  private UserExpectedPositionService userExpectedPositionService;

  @Autowired
  private UserEduExperienceService userEduExperienceService;

  @Autowired
  private UserCredentialService userCredentialService;

  @Autowired
  private UserExtendService userExtendService;

  @Autowired
  private UserInfoService userInfoService;

  @Autowired
  private UserWorkSkillTagService userWorkSkillTagService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserResume(UserResumeCreateReqDTO createReqDTO) {
    return userResumeService.saveUserResume(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserResume(UserResumeUpdateReqDTO updateReqDTO) {
    return userResumeService.updateUserResume(updateReqDTO);
  }


  /**
   * 根据用户id 查询简历信息
   *
   * @param userId
   * @return
   */
  public UserResumeRespDTO getUserResumeById(Long userId) {
    Calendar cal = Calendar.getInstance();
    UserResumeRespDTO userResumeResp = userResumeService.getUserResumeById(userId);
    if (userResumeResp == null) {
      return new UserResumeRespDTO();
    }
    Long resumeId = userResumeResp.getId();

    //项目经历
    List<UserProjectExperienceRespDTO> userProjectExperienceResp = userProjectExperienceService
        .listProjectExperience(resumeId);
    userResumeResp.setUserProjectExperienceList(userProjectExperienceResp);
    //工作经历
    List<UserWorkExperienceRespDTO> userWorkExperienceResp = userWorkExperienceService
        .listWorkExperience(resumeId);

    List<Long> workExperienceIds = userWorkExperienceResp.stream()
        .map(UserWorkExperienceRespDTO::getId)
        .collect(Collectors.toList());
    //根据工作经历ids 查询 工作经历_技能标签信息
    List<UserWorkSkillTagRespDTO> userWorkSkillTagResp = userWorkSkillTagService
        .listByWorkExperienceIds(workExperienceIds);
    // 工作经历id分组
    Map<Long, List<UserWorkSkillTagRespDTO>> workSkillTagMap = userWorkSkillTagResp.stream()
        .collect(Collectors.groupingBy(UserWorkSkillTagRespDTO::getWorkExperienceId));

    userWorkExperienceResp.forEach(v -> v.setWorkSkillTagList(workSkillTagMap.get(v.getId())));
    userResumeResp.setUserWorkExperienceList(userWorkExperienceResp);

    //专业技能
    List<UserProfessionalSkillRespDTO> userProfessionalSkillResp = userProfessionalSkillService
        .listProfessionalSkill(resumeId);
    userResumeResp.setUserProfessionalSkillList(userProfessionalSkillResp);
    // 求职期望
    List<UserExpectedPositionRespDTO> userExpectedPositionResp = userExpectedPositionService
        .listExpectedPosition(resumeId);
    userResumeResp.setUserExpectedPositionList(userExpectedPositionResp);
    // 教育经历
    List<UserEduExperienceRespDTO> userEduExperienceResp = userEduExperienceService
        .listEduExperience(resumeId);
    userResumeResp.setUserEduExperienceList(userEduExperienceResp);

    //用户_资格证书
    List<UserCredentialRespDTO> userCredentialResp = userCredentialService
        .listCredentialByResumeId(resumeId);
    userResumeResp.setUserCredentialList(userCredentialResp);
    //根据简历id 查找学历
    String education = userEduExperienceService.selectEducation(resumeId);
    userResumeResp.setEducation(education);
    //根据用户id 查询年龄
    if (userResumeResp.getBirthdayYear() != null) {
      userResumeResp.setAge(cal.get(Calendar.YEAR) - userResumeResp.getBirthdayYear());
    }
    //根据用户id 查询真实姓名
    UserExtendRespDTO userExtend = userExtendService.getUserExtendByUserId(userId);
    userResumeResp.setUsername(userExtend.getRealName());
    //根据用户id 查询用户信息头像
    UserInfoRespDTO userInfo = userInfoService.getUserInfo(userId);
    userResumeResp.setAvatarUrl(userInfo.getAvatarUrl());
    return userResumeResp;
  }


  /**
   * 根据用户ids 查找用户简历
   *
   * @param userIdsReqDTO
   * @return
   */
  public List<UserResumeDetailRespDTO> getResumeDetailByUserIds(UserIdsReqDTO userIdsReqDTO) {

    List<UserResumeRespDTO> userResumeList = userResumeService.listResumeByUserIds(userIdsReqDTO);
    if (CollectionUtils.isEmpty(userResumeList)) {
      return Collections.emptyList();
    }
    // 根据用户ids查询用户信息以及拓展信息
    Map<Long, UserPersonalInfoRespDTO> userInfoMap = userInfo(userIdsReqDTO.getUserIds());
    //获取简历ids
    List<Long> resumeIds = userResumeList.stream().map(UserResumeRespDTO::getId)
        .collect(Collectors.toList());
    Map<Long, UserResumeRespDTO> userResumeMap = userResumeList.stream()
        .collect(Collectors.toMap(UserResumeRespDTO::getUserId, a -> a, (k1, k2) -> k1));
    //根据简历ids 查询 学历表
    Map<Long, UserEduExperienceRespDTO> userEduExperienceMap = userEduExperience(resumeIds);
    //根据简历ids 查询期望表
    Map<Long, UserExpectedPositionRespDTO> userExpectedPositionMap = userExpectedPosition(
        resumeIds);
    //根据简历ids 查询工作经历表
    List<UserWorkExperienceRespDTO> userWorkExperienceResp = userWorkExperienceService
        .listWorkExperienceByResumeIds(resumeIds);
    Map<Long, UserWorkExperienceRespDTO> userWorkExperienceMap = userWorkExperienceResp.stream()
        .collect(
            Collectors.toMap(UserWorkExperienceRespDTO::getUserResumeId, a -> a, (k1, k2) -> k1));
    List<Long> workExperienceIds = userWorkExperienceResp.stream()
        .map(UserWorkExperienceRespDTO::getId).collect(Collectors.toList());
    Map<Long, List<UserWorkSkillTagRespDTO>> workSkillTagMap = new HashMap<>();
    if(!CollectionUtils.isEmpty(workExperienceIds)){
      //工作技能标签
      workSkillTagMap = userWorkSkillTag(workExperienceIds);
    }

    List<UserResumeDetailRespDTO> userDeliveryResumeList = new ArrayList<>();
    for (Long userId : userIdsReqDTO.getUserIds()) {
      UserResumeDetailRespDTO dto = new UserResumeDetailRespDTO();
      if (userResumeMap.get(userId) != null) {
        Long userResumeId = userResumeMap.get(userId).getId();
        //简历表
        dto.setEvaluate(userResumeMap.get(userId).getEvaluate());
        dto.setWorkYearTotal(userResumeMap.get(userId).getWorkYearTotal());
        dto.setAge(calculateBirthday(userId, userResumeMap));
        //教育经历
        dto.setEducationDictionaryId(null == userEduExperienceMap.get(userResumeId) ? null
            : userEduExperienceMap.get(userResumeId).getEducationDictionaryId());
        //求职期望
        dto.setStartSalary(null == userExpectedPositionMap.get(userResumeId) ? null
            : userExpectedPositionMap.get(userResumeId).getStartSalary());
        dto.setEndSalary(null == userExpectedPositionMap.get(userResumeId) ? null
            : userExpectedPositionMap.get(userResumeId).getEndSalary());
        //工作经历
        dto.setPositionName(null == userWorkExperienceMap.get(userResumeId) ? null
            : userWorkExperienceMap.get(userResumeId).getPositionName());
        dto.setCompanyName(null == userWorkExperienceMap.get(userResumeId) ? null
            : userWorkExperienceMap.get(userResumeId).getCompanyName());
        // 技能标签
        dto.setWorkSkillTagList(null == userWorkExperienceMap.get(userResumeId) ? null
            : workSkillTagMap.get(userWorkExperienceMap.get(userResumeId).getId()));
        if (userWorkExperienceMap.get(userResumeId) != null) {
          int workYear = calculateWorkYear(userResumeId, userWorkExperienceMap);
          dto.setLastCompanyWorkYear(workYear / 12 + "年" + workYear % 12 + "个月");
        }
      }
      //基础信息
      dto.setAvatarUrl(null == userInfoMap.get(userId) ? null
          : userInfoMap.get(userId).getAvatarUrl());
      //拓展信息
      dto.setRealName(null == userInfoMap.get(userId) ? null
          : userInfoMap.get(userId).getRealName());
      dto.setUserId(userId);
      userDeliveryResumeList.add(dto);
    }
    return userDeliveryResumeList;
  }


  private Map<Long, UserPersonalInfoRespDTO> userInfo(Set<Long> userIds) {
    // 根据用户查询用户头像
    List<UserPersonalInfoRespDTO> userPersonalInfoResp = userInfoService
        .listUserPersonalInfo(userIds);
    Map<Long, UserPersonalInfoRespDTO> userInfoMap = new HashMap<>();
    if (CollectionUtils.isEmpty(userPersonalInfoResp)) {
      return userInfoMap;
    }
    return userPersonalInfoResp.stream()
        .collect(Collectors.toMap(UserPersonalInfoRespDTO::getId, a -> a, (k1, k2) -> k1));
  }

  /**
   * 教育经历
   *
   * @param resumeIds
   * @return
   */
  private Map<Long, UserEduExperienceRespDTO> userEduExperience(List<Long> resumeIds) {
    List<UserEduExperienceRespDTO> userEduExperienceResp = userEduExperienceService
        .listEduExperienceByResumeIds(resumeIds);
    Map<Long, UserEduExperienceRespDTO> userEduExperienceMap = userEduExperienceResp.stream()
        .collect(
            Collectors.toMap(UserEduExperienceRespDTO::getUserResumeId, a -> a, (k1, k2) -> k1));
    return userEduExperienceMap;
  }

  /**
   * 求职期望
   *
   * @param resumeIds
   * @return
   */
  private Map<Long, UserExpectedPositionRespDTO> userExpectedPosition(List<Long> resumeIds) {
    List<UserExpectedPositionRespDTO> userExpectedPositionResp = userExpectedPositionService
        .listExpectedPositionByresumeIds(resumeIds);
    return userExpectedPositionResp.stream().collect(
        Collectors.toMap(UserExpectedPositionRespDTO::getUserResumeId, a -> a, (k1, k2) -> k1));
  }

  /**
   * 工作经历_技能标签信息
   *
   * @param workExperienceIds
   * @return
   */
  private Map<Long, List<UserWorkSkillTagRespDTO>> userWorkSkillTag(List<Long> workExperienceIds) {
    //根据工作经历ids 查询 工作经历_技能标签信息
    List<UserWorkSkillTagRespDTO> userWorkSkillTagResp = userWorkSkillTagService
        .listByWorkExperienceIds(workExperienceIds);
    // 工作经历id分组
    Map<Long, List<UserWorkSkillTagRespDTO>> workSkillTagMap = userWorkSkillTagResp.stream()
        .collect(Collectors.groupingBy(UserWorkSkillTagRespDTO::getWorkExperienceId));
    return workSkillTagMap;
  }

  /**
   * 计算年龄
   *
   * @param userId
   * @param userResumeMap
   * @return
   */

  private Integer calculateBirthday(Long userId, Map<Long, UserResumeRespDTO> userResumeMap) {
    String yearAndMonth =
        userResumeMap.get(userId).getBirthdayYear().toString() + userResumeMap.get(userId)
            .getBirthdayMonth().toString();
    DateTime birthday = DateUtil.parse(yearAndMonth, "yyyyMM");
    return DateUtil.age(birthday, new Date());
  }

  private Integer calculateWorkYear(Long userResumeId,
      Map<Long, UserWorkExperienceRespDTO> userWorkExperienceMap) {
    DateTime startJob = DateUtil
        .parse(userWorkExperienceMap.get(userResumeId).getStartJobTime().toString(),
            "yyyyMM");
    DateTime endJob = DateUtil
        .parse(userWorkExperienceMap.get(userResumeId).getQuitJobTime().toString(),
            "yyyyMM");
    long time = DateUtil.betweenMonth(startJob, endJob, true);
    return Math.toIntExact(time);
  }

}
