package com.db.chaomaxs.userservice.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.user.UserRecruitExtendConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserRecruitExtendDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserRecruitExtendMapper;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserRecruitExtendService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserRecruitExtendService {

  @Autowired
  private UserRecruitExtendMapper userRecruitExtendMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserRecruitExtend(UserRecruitExtendCreateReqDTO createReqDTO) {
    return userRecruitExtendMapper.insert(UserRecruitExtendConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserRecruitExtend(UserRecruitExtendUpdateReqDTO updateReqDTO) {
    UserRecruitExtendDO userRecruitExtendDO = userRecruitExtendMapper
        .selectById(updateReqDTO.getId());
    if (userRecruitExtendDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    userRecruitExtendDO = UserRecruitExtendConvert.INSTANCE.convert(updateReqDTO);
    int result = userRecruitExtendMapper.updateById(userRecruitExtendDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserRecruitExtend(Long id) {
    if (userRecruitExtendMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userRecruitExtendMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserRecruitExtendRespDTO> listUserRecruitExtends(
      UserRecruitExtendListQueryReqDTO listQueryReqDTO) {
    List<UserRecruitExtendDO> list = userRecruitExtendMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserRecruitExtendConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserRecruitExtendRespDTO getUserRecruitExtendById(Long id) {
    UserRecruitExtendDO userRecruitExtendDO = userRecruitExtendMapper.selectById(id);
    if (userRecruitExtendDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserRecruitExtendConvert.INSTANCE.convert(userRecruitExtendDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserRecruitExtendRespDTO> pageUserRecruitExtend(
      UserRecruitExtendPageReqDTO page) {
    IPage<UserRecruitExtendDO> userRecruitExtendPage = userRecruitExtendMapper.selectPage(page);
    return UserRecruitExtendConvert.INSTANCE.convertPage(userRecruitExtendPage);
  }


  /**
   * 根据userId更新用户招聘拓展信息
   *
   * @param userRecruitUpdateReqDTO
   * @return
   */
  public int updateUserRecruitExtendByUserId(UserRecruitUpdateReqDTO userRecruitUpdateReqDTO) {
    if (null == userRecruitUpdateReqDTO || null == userRecruitUpdateReqDTO.getUserId()) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    UserRecruitExtendDO userRecruitExtendDO = userRecruitExtendMapper
        .selectOne(new LambdaQueryWrapper<UserRecruitExtendDO>()
        .eq(UserRecruitExtendDO::getUserId, userRecruitUpdateReqDTO.getUserId()).select(UserRecruitExtendDO::getId));
    // 不存在时添加用户招聘信息
    if (userRecruitExtendDO == null) {
      userRecruitExtendDO = new UserRecruitExtendDO()
          .setUserId(userRecruitUpdateReqDTO.getUserId())
          .setPhotoUrl("")
          .setWeixin("")
          .setPosition(userRecruitUpdateReqDTO.getPosition())
          .setCompanyId(userRecruitUpdateReqDTO.getCompanyId())
          .setCompanyName(userRecruitUpdateReqDTO.getCompanyName());
      return userRecruitExtendMapper.insert(userRecruitExtendDO);
    }
    userRecruitExtendDO.setPosition(userRecruitUpdateReqDTO.getPosition())
        .setCompanyId(userRecruitUpdateReqDTO.getCompanyId())
        .setCompanyName(userRecruitUpdateReqDTO.getCompanyName())
        .setUserId(userRecruitUpdateReqDTO.getUserId());
    return userRecruitExtendMapper.updateById(userRecruitExtendDO);
  }

  public List<UserRecruitExtendRespDTO> getByUserIds(Set<Long> userIds) {
    List<UserRecruitExtendDO> userRecruitExtendDOs = userRecruitExtendMapper.getByUserIds(userIds);
    if (CollectionUtils.isEmpty(userRecruitExtendDOs)) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_RECRUIT_EXISTS.getCode());
    }
    return UserRecruitExtendConvert.INSTANCE.convertList(userRecruitExtendDOs);
  }

}
