package com.github.xf717.userservice.service.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.convert.resume.UserCredentialConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserCredentialDO;
import com.github.xf717.userservice.dal.mysql.mapper.resume.UserCredentialMapper;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialPageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserCredentialService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserCredentialService {

  @Autowired
  private UserCredentialMapper userCredentialMapper;

  private static final int TEN = 10;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserCredential(UserCredentialCreateReqDTO createReqDTO) {
    if (createReqDTO.getUserResumeId() == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_RESUME.getCode());
    }
    List<UserCredentialDO> userCredentialList = userCredentialMapper
        .listCredentialByResumeId(createReqDTO.getUserResumeId());
    if (userCredentialList.size() > TEN) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_CREDENTIAL_MORE_THAN_TEN.getCode());
    }
    return userCredentialMapper.insert(UserCredentialConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserCredential(UserCredentialUpdateReqDTO updateReqDTO) {
    UserCredentialDO userCredentialDO = userCredentialMapper.selectById(updateReqDTO.getId());
    if (userCredentialDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    userCredentialDO = UserCredentialConvert.INSTANCE.convert(updateReqDTO);
    int result = userCredentialMapper.updateById(userCredentialDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserCredential(Long id) {
    if (userCredentialMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userCredentialMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserCredentialRespDTO> listUserCredentials(
      UserCredentialListQueryReqDTO listQueryReqDTO) {
    List<UserCredentialDO> list = userCredentialMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserCredentialConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserCredentialRespDTO getUserCredentialById(Long id) {
    UserCredentialDO userCredentialDO = userCredentialMapper.selectById(id);
    if (userCredentialDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserCredentialConvert.INSTANCE.convert(userCredentialDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserCredentialRespDTO> pageUserCredential(UserCredentialPageReqDTO page) {
    IPage<UserCredentialDO> userCredentialPage = userCredentialMapper.selectPage(page);
    return UserCredentialConvert.INSTANCE.convertPage(userCredentialPage);
  }

  /**
   * 根据简历id 查询
   *
   * @param resumeId 简历id
   * @return
   */
  public List<UserCredentialRespDTO> listCredentialByResumeId(Long resumeId) {
    List<UserCredentialDO> userCredentialList = userCredentialMapper
        .listCredentialByResumeId(resumeId);
    if (CollectionUtils.isEmpty(userCredentialList)) {
      return Collections.emptyList();
    }
    return UserCredentialConvert.INSTANCE.convertList(userCredentialList);
  }

}
