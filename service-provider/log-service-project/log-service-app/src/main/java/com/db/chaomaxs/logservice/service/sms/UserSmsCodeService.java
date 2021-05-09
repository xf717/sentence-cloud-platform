package com.db.chaomaxs.logservice.service.sms;

import static com.db.chaomaxs.logservice.enums.LogErrorCodeConstants.USER_SMS_CODE_NOT_FOUND;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.logservice.convert.sms.UserSmsCodeConvert;
import com.db.chaomaxs.logservice.dal.mysql.dataobject.sms.UserSmsCodeDO;
import com.db.chaomaxs.logservice.dal.mysql.mapper.sms.UserSmsCodeMapper;
import com.db.chaomaxs.logservice.enums.LogErrorCodeConstants;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeCreateReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeListQueryReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodePageReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeRespDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserSmsCodeService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserSmsCodeService {

  @Autowired
  private UserSmsCodeMapper userSmsCodeMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserSmsCode(UserSmsCodeCreateReqDTO createReqDTO) {
    return userSmsCodeMapper.insert(UserSmsCodeConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserSmsCode(UserSmsCodeUpdateReqDTO updateReqDTO) {
    UserSmsCodeDO userSmsCodeDO = userSmsCodeMapper.selectById(updateReqDTO.getId());
    if (userSmsCodeDO == null) {
      throw ServiceExceptionUtil
          .exception(LogErrorCodeConstants.SMS_NOT_EXISTS.getCode());
    }
    userSmsCodeDO = UserSmsCodeConvert.INSTANCE.convert(updateReqDTO);
    int result = userSmsCodeMapper.updateById(userSmsCodeDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserSmsCode(Long id) {
    if (userSmsCodeMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(LogErrorCodeConstants.SMS_NOT_EXISTS.getCode());
    }
    int result = userSmsCodeMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserSmsCodeRespDTO> listUserSmsCodes(UserSmsCodeListQueryReqDTO listQueryReqDTO) {
    List<UserSmsCodeDO> list = userSmsCodeMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserSmsCodeConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserSmsCodeRespDTO getUserSmsCodeById(Long id) {
    UserSmsCodeDO userSmsCodeDO = userSmsCodeMapper.selectById(id);
    if (userSmsCodeDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(LogErrorCodeConstants.SMS_NOT_EXISTS.getCode());
    }
    return UserSmsCodeConvert.INSTANCE.convert(userSmsCodeDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserSmsCodeRespDTO> pageUserSmsCode(UserSmsCodePageReqDTO page) {
    IPage<UserSmsCodeDO> userSmsCodePage = userSmsCodeMapper.selectPage(page);
    return UserSmsCodeConvert.INSTANCE.convertPage(userSmsCodePage);
  }

  /**
   * 获取手机号码最后一条短信
   *
   * @param mobile
   * @param scene
   * @return
   */
  public UserSmsCodeRespDTO getLastCodeByMobile(String mobile, Integer scene) {
    UserSmsCodeDO userSmsCodeDO = userSmsCodeMapper.selectLastByMobile(mobile, scene);
//    if (userSmsCodeDO == null) {
//      throw ServiceExceptionUtil.exception(USER_SMS_CODE_NOT_FOUND);
//    }
    return UserSmsCodeConvert.INSTANCE.convert(userSmsCodeDO);
  }


}
