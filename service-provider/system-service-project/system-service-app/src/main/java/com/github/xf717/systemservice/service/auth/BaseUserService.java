package com.github.xf717.systemservice.service.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.convert.auth.BaseUserConvert;
import com.github.xf717.systemservice.dal.mysql.dataobject.auth.BaseUserDO;
import com.github.xf717.systemservice.dal.mysql.mapper.auth.BaseUserMapper;
import com.github.xf717.systemservice.enums.SystemErrorCodeConstants;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserUpdateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.GroupUsersRespDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ResourceService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class BaseUserService {

  @Autowired
  private BaseUserMapper baseUserMapper;


  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseUser(BaseUserCreateReqDTO createReqDTO) {
    BaseUserDO baseUserDO = baseUserMapper.selectByUserName(createReqDTO.getName());
    if (null != baseUserDO) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_EXISTS.getCode());
    }
    return baseUserMapper.insert(BaseUserConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseUser(BaseUserUpdateReqDTO updateReqDTO) {
    BaseUserDO baseUserDO = baseUserMapper.selectById(updateReqDTO.getId());
    if (baseUserDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    baseUserDO = BaseUserConvert.INSTANCE.convert(updateReqDTO);
    int result = baseUserMapper.updateById(baseUserDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseUser(Long id) {
    if (baseUserMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    int result = baseUserMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseUserRespDTO> listBaseUsers(BaseUserListQueryReqDTO listQueryReqDTO) {
    List<BaseUserDO> list = baseUserMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return BaseUserConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseUserRespDTO getBaseUserById(Long id) {
    BaseUserDO baseUserDO = baseUserMapper.selectById(id);
    if (baseUserDO == null) {
      // 错误码要自定义b
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    return BaseUserConvert.INSTANCE.convert(baseUserDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseUserRespDTO> pageBaseUser(BaseUserPageReqDTO page) {
    IPage<BaseUserDO> baseUserPage = baseUserMapper.selectPage(page);
    return BaseUserConvert.INSTANCE.convertPage(baseUserPage);
  }


  /**
   * 根据用户名查询
   *
   * @param userName
   * @param
   * @return
   */
  public BaseUserRespDTO selectByUserName(String userName) {
    BaseUserDO baseUserDO = baseUserMapper.selectByUserName(userName);
    if (baseUserDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    return BaseUserConvert.INSTANCE.convert(baseUserDO);
  }

  /**
   * 获取群组关联用户
   *
   * @param groupId
   * @return
   */
  public GroupUsersRespDTO getGroupUsers(Long groupId) {
    List<BaseUserDO> memberList = baseUserMapper.selectMemberByGroupId(groupId);
    List<BaseUserDO> leaderList = baseUserMapper.selectLeaderByGroupId(groupId);
    GroupUsersRespDTO groupUsers = new GroupUsersRespDTO(
        BaseUserConvert.INSTANCE.convertList(memberList),
        BaseUserConvert.INSTANCE.convertList(leaderList));
    return groupUsers;
  }
}
