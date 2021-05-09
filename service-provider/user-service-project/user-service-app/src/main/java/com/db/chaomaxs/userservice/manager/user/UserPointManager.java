package com.db.chaomaxs.userservice.manager.user;

import com.db.chaomaxs.userservice.rpc.user.dto.UserPointCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.service.user.UserPointService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserPointManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Service
@Validated
public class UserPointManager {

  @Autowired
  private UserPointService userPointService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserPoint(UserPointCreateReqDTO createReqDTO) {
    return userPointService.saveUserPoint(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserPoint(UserPointUpdateReqDTO updateReqDTO) {
      return userPointService.updateUserPoint(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserPoint(Long id) {
    return userPointService.deleteUserPoint(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserPointRespDTO> listUserPoints(UserPointListQueryReqDTO listQueryReqDTO) {
    return userPointService.listUserPoints(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserPointRespDTO getUserPointById(Long id) {
    return userPointService.getUserPointById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserPointRespDTO> pageUserPoint(UserPointPageReqDTO page) {
    return userPointService.pageUserPoint(page);
  }


}
