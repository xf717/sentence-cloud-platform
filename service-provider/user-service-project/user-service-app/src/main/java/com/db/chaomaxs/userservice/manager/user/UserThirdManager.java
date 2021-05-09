package com.db.chaomaxs.userservice.manager.user;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdUpdateReqDTO;
import com.db.chaomaxs.userservice.service.user.UserThirdService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserThirdManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Service
@Validated
public class UserThirdManager {

  @Autowired
  private UserThirdService userThirdService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserThird(UserThirdCreateReqDTO createReqDTO) {
    return userThirdService.saveUserThird(createReqDTO);
  }

  /**
   * 如果用户不存就创建，存在就返回
   *
   * @param createReqDTO
   * @return
   */
  public UserThirdRespDTO createUserThirdIfAbsent(UserThirdCreateReqDTO createReqDTO) {
    UserThirdRespDTO userThird = userThirdService
        .getUserThirdByThirdIden(createReqDTO.getThirdIden());
    if (userThird == null) {
      userThird = userThirdService.createUserThird(createReqDTO);
    }
    return userThird;
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserThird(UserThirdUpdateReqDTO updateReqDTO) {
    return userThirdService.updateUserThird(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserThird(Long id) {
    return userThirdService.deleteUserThird(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserThirdRespDTO> listUserThirds(UserThirdListQueryReqDTO listQueryReqDTO) {
    return userThirdService.listUserThirds(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserThirdRespDTO getUserThirdById(Long id) {
    return userThirdService.getUserThirdById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserThirdRespDTO> pageUserThird(UserThirdPageReqDTO page) {
    return userThirdService.pageUserThird(page);
  }


}
