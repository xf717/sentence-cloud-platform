package com.db.chaomaxs.userservice.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.user.UserMessageConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserMessageDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserMessageMapper;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessagePageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserMessageService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserMessageService {

  @Autowired
  private UserMessageMapper userMessageMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserMessage(UserMessageCreateReqDTO createReqDTO) {
    return userMessageMapper.insert(UserMessageConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserMessage(UserMessageUpdateReqDTO updateReqDTO) {
          UserMessageDO userMessageDO = userMessageMapper.selectById(updateReqDTO.getId());
    if (userMessageDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
          userMessageDO = UserMessageConvert.INSTANCE.convert(updateReqDTO);
    int result = userMessageMapper.updateById(userMessageDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserMessage(Long id) {
    if (userMessageMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userMessageMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserMessageRespDTO> listUserMessages(UserMessageListQueryReqDTO listQueryReqDTO) {
    List<UserMessageDO> list = userMessageMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserMessageConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserMessageRespDTO getUserMessageById(Long id) {
          UserMessageDO userMessageDO = userMessageMapper.selectById(id);
    if (userMessageDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserMessageConvert.INSTANCE.convert(userMessageDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserMessageRespDTO> pageUserMessage(UserMessagePageReqDTO page) {
    IPage<UserMessageDO> userMessagePage = userMessageMapper.selectPage(page);
    return UserMessageConvert.INSTANCE.convertPage(userMessagePage);
  }


}
