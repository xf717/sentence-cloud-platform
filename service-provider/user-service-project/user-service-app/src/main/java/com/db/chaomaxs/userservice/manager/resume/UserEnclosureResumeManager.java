package com.db.chaomaxs.userservice.manager.resume;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEnclosureResumeCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEnclosureResumePageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEnclosureResumeRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEnclosureResumeUpdateReqDTO;
import com.db.chaomaxs.userservice.service.resume.UserEnclosureResumeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserEnclosureResumeManager
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Service
@Validated
public class UserEnclosureResumeManager {

  @Autowired
  private UserEnclosureResumeService userEnclosureResumeService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserEnclosureResume(UserEnclosureResumeCreateReqDTO createReqDTO) {
    return userEnclosureResumeService.saveUserEnclosureResume(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserEnclosureResume(UserEnclosureResumeUpdateReqDTO updateReqDTO) {
      return userEnclosureResumeService.updateUserEnclosureResume(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserEnclosureResume(Long id) {
    return userEnclosureResumeService.deleteUserEnclosureResume(id);
  }

  /**
  * 数据查询
* @param userId
   *
* @return
*/
  public List<UserEnclosureResumeRespDTO> listUserEnclosureResumes(Long userId) {
    return userEnclosureResumeService.listUserEnclosureResumes(userId);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserEnclosureResumeRespDTO getUserEnclosureResumeById(Long id) {
    return userEnclosureResumeService.getUserEnclosureResumeById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserEnclosureResumeRespDTO> pageUserEnclosureResume(UserEnclosureResumePageReqDTO page) {
    return userEnclosureResumeService.pageUserEnclosureResume(page);
  }


}
