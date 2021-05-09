package com.db.chaomaxs.userservice.manager.resume;

import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperiencePageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.service.resume.UserProjectExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserProjectExperienceManager
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Service
@Validated
public class UserProjectExperienceManager {

  @Autowired
  private UserProjectExperienceService userProjectExperienceService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserProjectExperience(UserProjectExperienceCreateReqDTO createReqDTO) {
    return userProjectExperienceService.saveUserProjectExperience(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserProjectExperience(UserProjectExperienceUpdateReqDTO updateReqDTO) {
      return userProjectExperienceService.updateUserProjectExperience(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserProjectExperience(Long id) {
    return userProjectExperienceService.deleteUserProjectExperience(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserProjectExperienceRespDTO> listUserProjectExperiences(UserProjectExperienceListQueryReqDTO listQueryReqDTO) {
    return userProjectExperienceService.listUserProjectExperiences(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserProjectExperienceRespDTO getUserProjectExperienceById(Long id) {
    return userProjectExperienceService.getUserProjectExperienceById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserProjectExperienceRespDTO> pageUserProjectExperience(UserProjectExperiencePageReqDTO page) {
    return userProjectExperienceService.pageUserProjectExperience(page);
  }


}
