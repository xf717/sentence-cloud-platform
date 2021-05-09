package com.github.xf717.userservice.manager.user;

import com.github.xf717.userservice.rpc.user.dto.UserWordCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordUpdateReqDTO;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.service.user.UserWordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserWordManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Service
@Validated
public class UserWordManager {

  @Autowired
  private UserWordService userWordService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserWord(UserWordCreateReqDTO createReqDTO) {
    return userWordService.saveUserWord(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserWord(UserWordUpdateReqDTO updateReqDTO) {
      return userWordService.updateUserWord(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserWord(Long id) {
    return userWordService.deleteUserWord(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserWordRespDTO> listUserWords(UserWordListQueryReqDTO listQueryReqDTO) {
    return userWordService.listUserWords(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserWordRespDTO getUserWordById(Long id) {
    return userWordService.getUserWordById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserWordRespDTO> pageUserWord(UserWordPageReqDTO page) {
    return userWordService.pageUserWord(page);
  }

  /**
   * 置顶
   * @param id
   * @param userId
   * @return
   */
  public int userWordTopByUserId(Long id, Long userId){
    return userWordService.userWordTopByUserId(id,userId);
  }


}
