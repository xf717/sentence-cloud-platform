package com.db.chaomaxs.userservice.manager.user;

import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.service.user.UserIntegralRecordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserIntegralRecordManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Service
@Validated
public class UserIntegralRecordManager {

  @Autowired
  private UserIntegralRecordService userIntegralRecordService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserIntegralRecord(UserIntegralRecordCreateReqDTO createReqDTO) {
    return userIntegralRecordService.saveUserIntegralRecord(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserIntegralRecord(UserIntegralRecordUpdateReqDTO updateReqDTO) {
      return userIntegralRecordService.updateUserIntegralRecord(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserIntegralRecord(Long id) {
    return userIntegralRecordService.deleteUserIntegralRecord(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserIntegralRecordRespDTO> listUserIntegralRecords(UserIntegralRecordListQueryReqDTO listQueryReqDTO) {
    return userIntegralRecordService.listUserIntegralRecords(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserIntegralRecordRespDTO getUserIntegralRecordById(Long id) {
    return userIntegralRecordService.getUserIntegralRecordById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserIntegralRecordRespDTO> pageUserIntegralRecord(UserIntegralRecordPageReqDTO page) {
    return userIntegralRecordService.pageUserIntegralRecord(page);
  }
  /**
   * 保存数据
   * @param userId
   * @return
   */
  public int sign(Long userId) {
    return userIntegralRecordService.sign(userId);
  }

}
