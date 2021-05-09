package com.db.chaomaxs.userservice.manager.resume;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialPageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialUpdateReqDTO;
import com.db.chaomaxs.userservice.service.resume.UserCredentialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserCredentialManager
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Service
@Validated
public class UserCredentialManager {

  @Autowired
  private UserCredentialService userCredentialService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserCredential(UserCredentialCreateReqDTO createReqDTO) {
    return userCredentialService.saveUserCredential(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserCredential(UserCredentialUpdateReqDTO updateReqDTO) {
    return userCredentialService.updateUserCredential(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserCredential(Long id) {
    return userCredentialService.deleteUserCredential(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserCredentialRespDTO> listUserCredentials(
      UserCredentialListQueryReqDTO listQueryReqDTO) {
    return userCredentialService.listUserCredentials(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserCredentialRespDTO getUserCredentialById(Long id) {
    return userCredentialService.getUserCredentialById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserCredentialRespDTO> pageUserCredential(UserCredentialPageReqDTO page) {
    return userCredentialService.pageUserCredential(page);
  }


}
