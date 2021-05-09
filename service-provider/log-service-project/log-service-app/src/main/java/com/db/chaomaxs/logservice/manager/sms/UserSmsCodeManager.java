package com.db.chaomaxs.logservice.manager.sms;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeCreateReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeListQueryReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodePageReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeRespDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeUpdateReqDTO;
import com.db.chaomaxs.logservice.service.sms.UserSmsCodeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserSmsCodeManager
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:02
 */
@Service
@Validated
public class UserSmsCodeManager {

  @Autowired
  private UserSmsCodeService userSmsCodeService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserSmsCode(UserSmsCodeCreateReqDTO createReqDTO) {
    return userSmsCodeService.saveUserSmsCode(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserSmsCode(UserSmsCodeUpdateReqDTO updateReqDTO) {
    return userSmsCodeService.updateUserSmsCode(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserSmsCode(Long id) {
    return userSmsCodeService.deleteUserSmsCode(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserSmsCodeRespDTO> listUserSmsCodes(UserSmsCodeListQueryReqDTO listQueryReqDTO) {
    return userSmsCodeService.listUserSmsCodes(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserSmsCodeRespDTO getUserSmsCodeById(Long id) {
    return userSmsCodeService.getUserSmsCodeById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserSmsCodeRespDTO> pageUserSmsCode(UserSmsCodePageReqDTO page) {
    return userSmsCodeService.pageUserSmsCode(page);
  }

  /**
   * 获取最后一条短信
   *
   * @param mobile
   * @param scene
   * @return
   */
  public UserSmsCodeRespDTO getLastCodeByMobile(String mobile, Integer scene) {
    return userSmsCodeService.getLastCodeByMobile(mobile, scene);
  }


}
