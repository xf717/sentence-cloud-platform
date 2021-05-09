package com.db.chaomaxs.userservice.manager.user;

import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessagePageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.service.user.UserMessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserMessageManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Service
@Validated
public class UserMessageManager {

  @Autowired
  private UserMessageService userMessageService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserMessage(UserMessageCreateReqDTO createReqDTO) {
    return userMessageService.saveUserMessage(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserMessage(UserMessageUpdateReqDTO updateReqDTO) {
      return userMessageService.updateUserMessage(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserMessage(Long id) {
    return userMessageService.deleteUserMessage(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserMessageRespDTO> listUserMessages(UserMessageListQueryReqDTO listQueryReqDTO) {
    return userMessageService.listUserMessages(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserMessageRespDTO getUserMessageById(Long id) {
    return userMessageService.getUserMessageById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserMessageRespDTO> pageUserMessage(UserMessagePageReqDTO page) {
    return userMessageService.pageUserMessage(page);
  }


}
