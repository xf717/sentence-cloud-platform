package com.db.chaomaxs.userservice.manager.user;

import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.service.user.UserBlacklistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserBlacklistManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Service
@Validated
public class UserBlacklistManager {

  @Autowired
  private UserBlacklistService userBlacklistService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserBlacklist(UserBlacklistCreateReqDTO createReqDTO) {
    return userBlacklistService.saveUserBlacklist(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserBlacklist(UserBlacklistUpdateReqDTO updateReqDTO) {
      return userBlacklistService.updateUserBlacklist(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserBlacklist(Long id) {
    return userBlacklistService.deleteUserBlacklist(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserBlacklistRespDTO> listUserBlacklists(UserBlacklistListQueryReqDTO listQueryReqDTO) {
    return userBlacklistService.listUserBlacklists(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserBlacklistRespDTO getUserBlacklistById(Long id) {
    return userBlacklistService.getUserBlacklistById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserBlacklistRespDTO> pageUserBlacklist(UserBlacklistPageReqDTO page) {
    return userBlacklistService.pageUserBlacklist(page);
  }


}
