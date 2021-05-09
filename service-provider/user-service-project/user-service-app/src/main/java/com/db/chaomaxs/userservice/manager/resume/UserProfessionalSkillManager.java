package com.db.chaomaxs.userservice.manager.resume;

import com.db.chaomaxs.userservice.rpc.resume.dto.UserProfessionalSkillCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProfessionalSkillListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProfessionalSkillPageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProfessionalSkillRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProfessionalSkillUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.service.resume.UserProfessionalSkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserProfessionalSkillManager
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Service
@Validated
public class UserProfessionalSkillManager {

  @Autowired
  private UserProfessionalSkillService userProfessionalSkillService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserProfessionalSkill(UserProfessionalSkillCreateReqDTO createReqDTO) {
    return userProfessionalSkillService.saveUserProfessionalSkill(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserProfessionalSkill(UserProfessionalSkillUpdateReqDTO updateReqDTO) {
      return userProfessionalSkillService.updateUserProfessionalSkill(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserProfessionalSkill(Long id) {
    return userProfessionalSkillService.deleteUserProfessionalSkill(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserProfessionalSkillRespDTO> listUserProfessionalSkills(UserProfessionalSkillListQueryReqDTO listQueryReqDTO) {
    return userProfessionalSkillService.listUserProfessionalSkills(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserProfessionalSkillRespDTO getUserProfessionalSkillById(Long id) {
    return userProfessionalSkillService.getUserProfessionalSkillById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserProfessionalSkillRespDTO> pageUserProfessionalSkill(UserProfessionalSkillPageReqDTO page) {
    return userProfessionalSkillService.pageUserProfessionalSkill(page);
  }


}
