package com.github.xf717.logservice.service.login;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.logservice.convert.login.UserLoginLogConvert;
import com.github.xf717.logservice.dal.mysql.dataobject.login.UserLoginLogDO;
import com.github.xf717.logservice.dal.mysql.mapper.login.UserLoginLogMapper;
import com.github.xf717.logservice.enums.LogErrorCodeConstants;
import com.github.xf717.logservice.rpc.login.dto.UserLoginLogCreateReqDTO;
import com.github.xf717.logservice.rpc.login.dto.UserLoginLogListQueryReqDTO;
import com.github.xf717.logservice.rpc.login.dto.UserLoginLogPageReqDTO;
import com.github.xf717.logservice.rpc.login.dto.UserLoginLogRespDTO;
import com.github.xf717.logservice.rpc.login.dto.UserLoginLogUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserLoginLogService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserLoginLogService {

  @Autowired
  private UserLoginLogMapper userLoginLogMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserLoginLog(UserLoginLogCreateReqDTO createReqDTO) {
    return userLoginLogMapper.insert(UserLoginLogConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserLoginLog(UserLoginLogUpdateReqDTO updateReqDTO) {
    UserLoginLogDO userLoginLogDO = userLoginLogMapper.selectById(updateReqDTO.getId());
    if (userLoginLogDO == null) {
      throw ServiceExceptionUtil
          .exception(LogErrorCodeConstants.USER_LOGIN_LOG_NOT_EXISTS.getCode());
    }
    userLoginLogDO = UserLoginLogConvert.INSTANCE.convert(updateReqDTO);
    int result = userLoginLogMapper.updateById(userLoginLogDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserLoginLog(Long id) {
    if (userLoginLogMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(LogErrorCodeConstants.USER_LOGIN_LOG_NOT_EXISTS.getCode());
    }
    int result = userLoginLogMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserLoginLogRespDTO> listUserLoginLogs(UserLoginLogListQueryReqDTO listQueryReqDTO) {
    List<UserLoginLogDO> list = userLoginLogMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserLoginLogConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserLoginLogRespDTO getUserLoginLogById(Long id) {
    UserLoginLogDO userLoginLogDO = userLoginLogMapper.selectById(id);
    if (userLoginLogDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(LogErrorCodeConstants.USER_LOGIN_LOG_NOT_EXISTS.getCode());
    }
    return UserLoginLogConvert.INSTANCE.convert(userLoginLogDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserLoginLogRespDTO> pageUserLoginLog(UserLoginLogPageReqDTO page) {
    IPage<UserLoginLogDO> userLoginLogPage = userLoginLogMapper.selectPage(page);
    return UserLoginLogConvert.INSTANCE.convertPage(userLoginLogPage);
  }


}
