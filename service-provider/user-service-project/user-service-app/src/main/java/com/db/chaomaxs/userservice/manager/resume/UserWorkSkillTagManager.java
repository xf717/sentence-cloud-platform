package com.db.chaomaxs.userservice.manager.resume;

import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagPageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.service.resume.UserWorkSkillTagService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserWorkSkillTagManager
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Service
@Validated
public class UserWorkSkillTagManager {

  @Autowired
  private UserWorkSkillTagService userWorkSkillTagService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserWorkSkillTag(UserWorkSkillTagCreateReqDTO createReqDTO) {
    return userWorkSkillTagService.saveUserWorkSkillTag(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserWorkSkillTag(UserWorkSkillTagUpdateReqDTO updateReqDTO) {
      return userWorkSkillTagService.updateUserWorkSkillTag(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserWorkSkillTag(Long id) {
    return userWorkSkillTagService.deleteUserWorkSkillTag(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserWorkSkillTagRespDTO> listUserWorkSkillTags(UserWorkSkillTagListQueryReqDTO listQueryReqDTO) {
    return userWorkSkillTagService.listUserWorkSkillTags(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserWorkSkillTagRespDTO getUserWorkSkillTagById(Long id) {
    return userWorkSkillTagService.getUserWorkSkillTagById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserWorkSkillTagRespDTO> pageUserWorkSkillTag(UserWorkSkillTagPageReqDTO page) {
    return userWorkSkillTagService.pageUserWorkSkillTag(page);
  }


}
