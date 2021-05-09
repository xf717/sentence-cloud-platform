package com.db.chaomaxs.systemservice.manager.auth;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserUpdateReqDTO;
import com.db.chaomaxs.systemservice.service.auth.BaseUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * BaseUserManager
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Service
@Validated
public class BaseUserManager {

  @Autowired
  private BaseUserService baseUserService;


  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseUser(BaseUserCreateReqDTO createReqDTO) {
    return baseUserService.saveBaseUser(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseUser(BaseUserUpdateReqDTO updateReqDTO) {
    return baseUserService.updateBaseUser(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseUser(Long id) {
    return baseUserService.deleteBaseUser(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseUserRespDTO> listBaseUsers(BaseUserListQueryReqDTO listQueryReqDTO) {
    return baseUserService.listBaseUsers(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseUserRespDTO getBaseUserById(Long id) {
    return baseUserService.getBaseUserById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseUserRespDTO> pageBaseUser(BaseUserPageReqDTO page) {
    return baseUserService.pageBaseUser(page);
  }

  /**
   * 根据用户名获取用户信息
   * @param username
   * @return
   */
  public BaseUserRespDTO getUserByUsername(final String username) {
    return baseUserService.selectByUserName(username);
  }

}
