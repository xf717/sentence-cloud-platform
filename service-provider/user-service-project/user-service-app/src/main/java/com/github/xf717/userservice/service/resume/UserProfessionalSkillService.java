package com.github.xf717.userservice.service.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.convert.resume.UserProfessionalSkillConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserProfessionalSkillDO;
import com.github.xf717.userservice.dal.mysql.mapper.resume.UserProfessionalSkillMapper;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillPageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserProfessionalSkillService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserProfessionalSkillService {

  @Autowired
  private UserProfessionalSkillMapper userProfessionalSkillMapper;

  private static final int TEN = 10;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserProfessionalSkill(UserProfessionalSkillCreateReqDTO createReqDTO) {
    if (createReqDTO.getUserResumeId() == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_RESUME.getCode());
    }
    List<UserProfessionalSkillDO> userProfessionalSkillList = userProfessionalSkillMapper
        .listProfessionalSkill(createReqDTO.getUserResumeId());
    if (userProfessionalSkillList.size() > TEN) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_PROFESSIONAL_SKILL_MORE_THAN_TEN.getCode());
    }
    return userProfessionalSkillMapper
        .insert(UserProfessionalSkillConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserProfessionalSkill(UserProfessionalSkillUpdateReqDTO updateReqDTO) {
          UserProfessionalSkillDO userProfessionalSkillDO = userProfessionalSkillMapper.selectById(updateReqDTO.getId());
    if (userProfessionalSkillDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
          userProfessionalSkillDO = UserProfessionalSkillConvert.INSTANCE.convert(updateReqDTO);
    int result = userProfessionalSkillMapper.updateById(userProfessionalSkillDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserProfessionalSkill(Long id) {
    if (userProfessionalSkillMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userProfessionalSkillMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserProfessionalSkillRespDTO> listUserProfessionalSkills(UserProfessionalSkillListQueryReqDTO listQueryReqDTO) {
    List<UserProfessionalSkillDO> list = userProfessionalSkillMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserProfessionalSkillConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserProfessionalSkillRespDTO getUserProfessionalSkillById(Long id) {
          UserProfessionalSkillDO userProfessionalSkillDO = userProfessionalSkillMapper.selectById(id);
    if (userProfessionalSkillDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserProfessionalSkillConvert.INSTANCE.convert(userProfessionalSkillDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserProfessionalSkillRespDTO> pageUserProfessionalSkill(UserProfessionalSkillPageReqDTO page) {
    IPage<UserProfessionalSkillDO> userProfessionalSkillPage = userProfessionalSkillMapper.selectPage(page);
    return UserProfessionalSkillConvert.INSTANCE.convertPage(userProfessionalSkillPage);
  }

  /**
   * 根据简历id 查询
   * @param resumeId 简历id
   * @return
   */
  public List<UserProfessionalSkillRespDTO> listProfessionalSkill(Long resumeId) {
    List<UserProfessionalSkillDO> list = userProfessionalSkillMapper.listProfessionalSkill(resumeId);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserProfessionalSkillConvert.INSTANCE.convertList(list);
  }


}
