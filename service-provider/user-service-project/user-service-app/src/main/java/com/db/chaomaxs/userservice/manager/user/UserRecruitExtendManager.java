package com.db.chaomaxs.userservice.manager.user;

import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.service.user.UserRecruitExtendService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserRecruitExtendManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:54:37
 */
@Service
@Validated
public class UserRecruitExtendManager {

  @Autowired
  private UserRecruitExtendService userRecruitExtendService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserRecruitExtend(UserRecruitExtendCreateReqDTO createReqDTO) {
    return userRecruitExtendService.saveUserRecruitExtend(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserRecruitExtend(UserRecruitExtendUpdateReqDTO updateReqDTO) {
      return userRecruitExtendService.updateUserRecruitExtend(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserRecruitExtend(Long id) {
    return userRecruitExtendService.deleteUserRecruitExtend(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserRecruitExtendRespDTO> listUserRecruitExtends(UserRecruitExtendListQueryReqDTO listQueryReqDTO) {
    return userRecruitExtendService.listUserRecruitExtends(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserRecruitExtendRespDTO getUserRecruitExtendById(Long id) {
    return userRecruitExtendService.getUserRecruitExtendById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserRecruitExtendRespDTO> pageUserRecruitExtend(UserRecruitExtendPageReqDTO page) {
    return userRecruitExtendService.pageUserRecruitExtend(page);
  }


}
