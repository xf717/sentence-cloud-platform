package com.db.chaomaxs.userservice.service.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.resume.UserProjectExperienceConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.resume.UserProjectExperienceDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.resume.UserProjectExperienceMapper;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperiencePageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserProjectExperienceService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserProjectExperienceService {

  @Autowired
  private UserProjectExperienceMapper userProjectExperienceMapper;

  private static final int TEN = 10;
  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserProjectExperience(UserProjectExperienceCreateReqDTO createReqDTO) {
    if (createReqDTO.getUserResumeId() == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_RESUME.getCode());
    }
      List<UserProjectExperienceDO> userProjectExperienceList = userProjectExperienceMapper
          .listProjectExperience(createReqDTO.getUserResumeId());
      if (userProjectExperienceList.size() > TEN) {
        throw ServiceExceptionUtil
            .exception(UserErrorCodeConstants.USER_PROJECT_EXPERIENCE_MORE_THAN_TEN.getCode());
      }
    return userProjectExperienceMapper.insert(UserProjectExperienceConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserProjectExperience(UserProjectExperienceUpdateReqDTO updateReqDTO) {
    UserProjectExperienceDO userProjectExperienceDO = userProjectExperienceMapper
        .selectById(updateReqDTO.getId());
    if (userProjectExperienceDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    userProjectExperienceDO = UserProjectExperienceConvert.INSTANCE.convert(updateReqDTO);
    int result = userProjectExperienceMapper.updateById(userProjectExperienceDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserProjectExperience(Long id) {
    if (userProjectExperienceMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userProjectExperienceMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserProjectExperienceRespDTO> listUserProjectExperiences(UserProjectExperienceListQueryReqDTO listQueryReqDTO) {
    List<UserProjectExperienceDO> list = userProjectExperienceMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserProjectExperienceConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserProjectExperienceRespDTO getUserProjectExperienceById(Long id) {
          UserProjectExperienceDO userProjectExperienceDO = userProjectExperienceMapper.selectById(id);
    if (userProjectExperienceDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserProjectExperienceConvert.INSTANCE.convert(userProjectExperienceDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserProjectExperienceRespDTO> pageUserProjectExperience(UserProjectExperiencePageReqDTO page) {
    IPage<UserProjectExperienceDO> userProjectExperiencePage = userProjectExperienceMapper.selectPage(page);
    return UserProjectExperienceConvert.INSTANCE.convertPage(userProjectExperiencePage);
  }

  /**
   * 根据简历id 查询
   * @param resumeId 简历id
   * @return
   */
  public List<UserProjectExperienceRespDTO> listProjectExperience(Long resumeId) {
    List<UserProjectExperienceDO> list = userProjectExperienceMapper.listProjectExperience(resumeId);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserProjectExperienceConvert.INSTANCE.convertList(list);
  }

}
