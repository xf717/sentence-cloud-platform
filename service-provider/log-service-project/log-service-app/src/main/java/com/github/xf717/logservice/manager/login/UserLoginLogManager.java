package com.github.xf717.logservice.manager.login;

import com.github.xf717.logservice.rpc.login.dto.UserLoginLogCreateReqDTO;
import com.github.xf717.logservice.rpc.login.dto.UserLoginLogListQueryReqDTO;
import com.github.xf717.logservice.rpc.login.dto.UserLoginLogPageReqDTO;
import com.github.xf717.logservice.rpc.login.dto.UserLoginLogRespDTO;
import com.github.xf717.logservice.rpc.login.dto.UserLoginLogUpdateReqDTO;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.logservice.service.login.UserLoginLogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserLoginLogManager
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:03
 */
@Service
@Validated
public class UserLoginLogManager {

  @Autowired
  private UserLoginLogService userLoginLogService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserLoginLog(UserLoginLogCreateReqDTO createReqDTO) {
    return userLoginLogService.saveUserLoginLog(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserLoginLog(UserLoginLogUpdateReqDTO updateReqDTO) {
      return userLoginLogService.updateUserLoginLog(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserLoginLog(Long id) {
    return userLoginLogService.deleteUserLoginLog(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserLoginLogRespDTO> listUserLoginLogs(UserLoginLogListQueryReqDTO listQueryReqDTO) {
    return userLoginLogService.listUserLoginLogs(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserLoginLogRespDTO getUserLoginLogById(Long id) {
    return userLoginLogService.getUserLoginLogById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserLoginLogRespDTO> pageUserLoginLog(UserLoginLogPageReqDTO page) {
    return userLoginLogService.pageUserLoginLog(page);
  }


}
