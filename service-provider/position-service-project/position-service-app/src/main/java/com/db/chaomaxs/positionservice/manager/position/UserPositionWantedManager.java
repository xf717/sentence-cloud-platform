package com.db.chaomaxs.positionservice.manager.position;

import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.service.position.UserPositionWantedService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserPositionWantedManager
 *
 * @author xiaofeng
 * @date 2021-03-29 16:36:57
 */
@Service
@Validated
public class UserPositionWantedManager {

  @Autowired
  private UserPositionWantedService userPositionWantedService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserPositionWanted(UserPositionWantedCreateReqDTO createReqDTO) {
    return userPositionWantedService.saveUserPositionWanted(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserPositionWanted(UserPositionWantedUpdateReqDTO updateReqDTO) {
      return userPositionWantedService.updateUserPositionWanted(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserPositionWanted(Long id) {
    return userPositionWantedService.deleteUserPositionWanted(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserPositionWantedRespDTO> listUserPositionWanteds(UserPositionWantedListQueryReqDTO listQueryReqDTO) {
    return userPositionWantedService.listUserPositionWanteds(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserPositionWantedRespDTO getUserPositionWantedById(Long id) {
    return userPositionWantedService.getUserPositionWantedById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserPositionWantedRespDTO> pageUserPositionWanted(UserPositionWantedPageReqDTO page) {
    return userPositionWantedService.pageUserPositionWanted(page);
  }


}
