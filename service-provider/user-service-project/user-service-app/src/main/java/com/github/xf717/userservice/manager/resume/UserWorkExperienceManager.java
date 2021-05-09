package com.github.xf717.userservice.manager.resume;

import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperiencePageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceUpdateReqDTO;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.service.resume.UserWorkExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserWorkExperienceManager
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Service
@Validated
public class UserWorkExperienceManager {

  @Autowired
  private UserWorkExperienceService userWorkExperienceService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserWorkExperience(UserWorkExperienceCreateReqDTO createReqDTO) {
    return userWorkExperienceService.saveUserWorkExperience(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserWorkExperience(UserWorkExperienceUpdateReqDTO updateReqDTO) {
      return userWorkExperienceService.updateUserWorkExperience(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserWorkExperience(Long id) {
    return userWorkExperienceService.deleteUserWorkExperience(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserWorkExperienceRespDTO> listUserWorkExperiences(UserWorkExperienceListQueryReqDTO listQueryReqDTO) {
    return userWorkExperienceService.listUserWorkExperiences(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserWorkExperienceRespDTO getUserWorkExperienceById(Long id) {
    return userWorkExperienceService.getUserWorkExperienceById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserWorkExperienceRespDTO> pageUserWorkExperience(UserWorkExperiencePageReqDTO page) {
    return userWorkExperienceService.pageUserWorkExperience(page);
  }

  /**
   * 填写资料返回上一步时查询工作经历信息
   * @param userId
   * @return
   */
  public UserWorkExperienceRespDTO getLastStepByUserId(Long userId) {
    return userWorkExperienceService.getLastStepByUserId(userId);
  }

}
