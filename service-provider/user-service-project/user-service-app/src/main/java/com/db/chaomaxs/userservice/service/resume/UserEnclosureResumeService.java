package com.db.chaomaxs.userservice.service.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.resume.UserEnclosureResumeConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.resume.UserEnclosureResumeDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.resume.UserEnclosureResumeMapper;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEnclosureResumeCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEnclosureResumePageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEnclosureResumeRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEnclosureResumeUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserEnclosureResumeService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserEnclosureResumeService {

  @Autowired
  private UserEnclosureResumeMapper userEnclosureResumeMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserEnclosureResume(UserEnclosureResumeCreateReqDTO createReqDTO) {
    return userEnclosureResumeMapper.insert(UserEnclosureResumeConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserEnclosureResume(UserEnclosureResumeUpdateReqDTO updateReqDTO) {
    UserEnclosureResumeDO userEnclosureResumeDO = userEnclosureResumeMapper
        .selectById(updateReqDTO.getId());
    if (userEnclosureResumeDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    userEnclosureResumeDO = UserEnclosureResumeConvert.INSTANCE.convert(updateReqDTO);
    int result = userEnclosureResumeMapper.updateById(userEnclosureResumeDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserEnclosureResume(Long id) {
    if (userEnclosureResumeMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userEnclosureResumeMapper.deleteById(id);
    return result;
  }

  /**
  * 根据用户id 查询附件简历信息
* @param userId
* @return
*/
  public List<UserEnclosureResumeRespDTO> listUserEnclosureResumes(Long userId) {
    List<UserEnclosureResumeDO> list = userEnclosureResumeMapper.selectByUserId(userId);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserEnclosureResumeConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserEnclosureResumeRespDTO getUserEnclosureResumeById(Long id) {
          UserEnclosureResumeDO userEnclosureResumeDO = userEnclosureResumeMapper.selectById(id);
    if (userEnclosureResumeDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserEnclosureResumeConvert.INSTANCE.convert(userEnclosureResumeDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserEnclosureResumeRespDTO> pageUserEnclosureResume(UserEnclosureResumePageReqDTO page) {
    IPage<UserEnclosureResumeDO> userEnclosureResumePage = userEnclosureResumeMapper.selectPage(page);
    return UserEnclosureResumeConvert.INSTANCE.convertPage(userEnclosureResumePage);
  }


}
