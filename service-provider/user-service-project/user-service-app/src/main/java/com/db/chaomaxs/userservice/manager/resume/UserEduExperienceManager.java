package com.db.chaomaxs.userservice.manager.resume;

import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperienceCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperienceListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperiencePageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperienceRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperienceUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.service.resume.UserEduExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserEduExperienceManager
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Service
@Validated
public class UserEduExperienceManager {

  @Autowired
  private UserEduExperienceService userEduExperienceService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserEduExperience(UserEduExperienceCreateReqDTO createReqDTO) {
    return userEduExperienceService.saveUserEduExperience(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserEduExperience(UserEduExperienceUpdateReqDTO updateReqDTO) {
    return userEduExperienceService.updateUserEduExperience(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserEduExperience(Long id) {
    return userEduExperienceService.deleteUserEduExperience(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserEduExperienceRespDTO> listUserEduExperiences(
      UserEduExperienceListQueryReqDTO listQueryReqDTO) {
    return userEduExperienceService.listUserEduExperiences(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserEduExperienceRespDTO getUserEduExperienceById(Long id) {
    return userEduExperienceService.getUserEduExperienceById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserEduExperienceRespDTO> pageUserEduExperience(
      UserEduExperiencePageReqDTO page) {
    return userEduExperienceService.pageUserEduExperience(page);
  }

  /**
   * 填写个人资料时返回上一步时根据用户查询学历信息
   *
   * @param userId
   * @return
   */
  public UserEduExperienceRespDTO getLastStepByUserId(Long userId) {
    return userEduExperienceService.getLastStepByUserId(userId);
  }
}
