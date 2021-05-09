package com.github.xf717.userservice.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.convert.user.UserBlacklistConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserBlacklistDO;
import com.github.xf717.userservice.dal.mysql.mapper.user.UserBlacklistMapper;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserBlacklistService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserBlacklistService {

  @Autowired
  private UserBlacklistMapper userBlacklistMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserBlacklist(UserBlacklistCreateReqDTO createReqDTO) {
    return userBlacklistMapper.insert(UserBlacklistConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserBlacklist(UserBlacklistUpdateReqDTO updateReqDTO) {
          UserBlacklistDO userBlacklistDO = userBlacklistMapper.selectById(updateReqDTO.getId());
    if (userBlacklistDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
          userBlacklistDO = UserBlacklistConvert.INSTANCE.convert(updateReqDTO);
    int result = userBlacklistMapper.updateById(userBlacklistDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserBlacklist(Long id) {
    if (userBlacklistMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userBlacklistMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserBlacklistRespDTO> listUserBlacklists(UserBlacklistListQueryReqDTO listQueryReqDTO) {
    List<UserBlacklistDO> list = userBlacklistMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserBlacklistConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserBlacklistRespDTO getUserBlacklistById(Long id) {
          UserBlacklistDO userBlacklistDO = userBlacklistMapper.selectById(id);
    if (userBlacklistDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserBlacklistConvert.INSTANCE.convert(userBlacklistDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserBlacklistRespDTO> pageUserBlacklist(UserBlacklistPageReqDTO page) {
    IPage<UserBlacklistDO> userBlacklistPage = userBlacklistMapper.selectPage(page);
    return UserBlacklistConvert.INSTANCE.convertPage(userBlacklistPage);
  }


}
