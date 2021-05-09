package com.db.chaomaxs.userservice.service.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.resume.UserWorkSkillTagConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.resume.UserWorkSkillTagDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.resume.UserWorkSkillTagMapper;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagPageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserWorkSkillTagService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserWorkSkillTagService {

  @Autowired
  private UserWorkSkillTagMapper userWorkSkillTagMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserWorkSkillTag(UserWorkSkillTagCreateReqDTO createReqDTO) {
    return userWorkSkillTagMapper.insert(UserWorkSkillTagConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserWorkSkillTag(UserWorkSkillTagUpdateReqDTO updateReqDTO) {
          UserWorkSkillTagDO userWorkSkillTagDO = userWorkSkillTagMapper.selectById(updateReqDTO.getId());
    if (userWorkSkillTagDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
          userWorkSkillTagDO = UserWorkSkillTagConvert.INSTANCE.convert(updateReqDTO);
    int result = userWorkSkillTagMapper.updateById(userWorkSkillTagDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserWorkSkillTag(Long id) {
    if (userWorkSkillTagMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userWorkSkillTagMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserWorkSkillTagRespDTO> listUserWorkSkillTags(UserWorkSkillTagListQueryReqDTO listQueryReqDTO) {
    List<UserWorkSkillTagDO> list = userWorkSkillTagMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserWorkSkillTagConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserWorkSkillTagRespDTO getUserWorkSkillTagById(Long id) {
          UserWorkSkillTagDO userWorkSkillTagDO = userWorkSkillTagMapper.selectById(id);
    if (userWorkSkillTagDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserWorkSkillTagConvert.INSTANCE.convert(userWorkSkillTagDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserWorkSkillTagRespDTO> pageUserWorkSkillTag(UserWorkSkillTagPageReqDTO page) {
    IPage<UserWorkSkillTagDO> userWorkSkillTagPage = userWorkSkillTagMapper.selectPage(page);
    return UserWorkSkillTagConvert.INSTANCE.convertPage(userWorkSkillTagPage);
  }

  /**
   * 工作经验ids 查询
   * @param workExperienceIds 工作经验ids
   * @return
   */
  public List<UserWorkSkillTagRespDTO> listByWorkExperienceIds(List<Long> workExperienceIds) {
    List<UserWorkSkillTagDO> userWorkSkillTag = userWorkSkillTagMapper
        .listByWorkExperienceIds(workExperienceIds);
    if (CollectionUtils.isEmpty(userWorkSkillTag)) {
      return Collections.emptyList();
    }
    return UserWorkSkillTagConvert.INSTANCE.convertList(userWorkSkillTag);
  }

}
