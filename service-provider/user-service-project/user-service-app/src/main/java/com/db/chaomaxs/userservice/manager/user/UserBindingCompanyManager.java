package com.db.chaomaxs.userservice.manager.user;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.user.UserBindingCompanyConvert;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingCompanyCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingCompanyListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingCompanyPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingCompanyRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingCompanyUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingExtendRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingStateUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingTransferReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendRespDTO;
import com.db.chaomaxs.userservice.service.user.UserBindingCompanyService;
import com.db.chaomaxs.userservice.service.user.UserExtendService;
import com.db.chaomaxs.userservice.service.user.UserInfoService;
import com.db.chaomaxs.userservice.service.user.UserRecruitExtendService;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserBindingCompanyManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Service
@Validated
public class UserBindingCompanyManager {

  @Autowired
  private UserBindingCompanyService userBindingCompanyService;

  @Autowired
  private UserInfoService userInfoService;

  @Autowired
  private UserExtendService userExtendService;

  @Autowired
  private UserRecruitExtendService userRecruitExtendService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserBindingCompany(UserBindingCompanyCreateReqDTO createReqDTO) {
    return userBindingCompanyService.saveUserBindingCompany(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserBindingCompany(UserBindingCompanyUpdateReqDTO updateReqDTO) {
    return userBindingCompanyService.updateUserBindingCompany(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserBindingCompany(Long id) {
    return userBindingCompanyService.deleteUserBindingCompany(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserBindingCompanyRespDTO> listUserBindingCompanys(
      UserBindingCompanyListQueryReqDTO listQueryReqDTO) {
    return userBindingCompanyService.listUserBindingCompanys(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserBindingCompanyRespDTO getUserBindingCompanyById(Long id) {
    return userBindingCompanyService.getUserBindingCompanyById(id);
  }

  /**
   * 用户绑定信息分页
   *
   * @param page
   * @return
   */
  public PageResult<UserBindingInfoRespDTO> pageUserBindingCompany(
      UserBindingCompanyPageReqDTO page) {
    PageResult<UserBindingCompanyRespDTO> userBindingPageResult = userBindingCompanyService
        .pageUserBindingCompany(page);
    if (CollectionUtils.isEmpty(userBindingPageResult.getList())) {
      return new PageResult();
    }
    PageResult<UserBindingInfoRespDTO> pageResult =
        UserBindingCompanyConvert.INSTANCE.convertToUserBindingInfo(userBindingPageResult);
    Set<Long> userIds = userBindingPageResult.getList()
        .stream().map(UserBindingCompanyRespDTO::getUserId).collect(Collectors.toSet());
    if (CollectionUtils.isEmpty(userIds)) {
      return pageResult;
    }
    // 获取用户信息
    List<UserInfoRespDTO> userInfoRespDTOs = userInfoService.listUserInfoByUserIds(userIds);
    Map<Long, UserInfoRespDTO> userInfoMap = userInfoRespDTOs.stream()
        .collect(Collectors.toMap(UserInfoRespDTO::getId, a -> a, (k1, k2) -> k2));

    // 获取用户拓展信息
    List<UserExtendRespDTO> userExtendRespDTOs = userExtendService.listUserExtendByUserIds(userIds);
    Map<Long, UserExtendRespDTO> userExtendMap = userExtendRespDTOs.stream()
        .collect(Collectors.toMap(UserExtendRespDTO::getUserId, a -> a, (k1, k2) -> k2));

    // 获取用户招聘拓展信息
    List<UserRecruitExtendRespDTO> userRecruitExtendRespDTOs = userRecruitExtendService.getByUserIds(userIds);
    Map<Long, UserRecruitExtendRespDTO> userRecruitExtendMap = userRecruitExtendRespDTOs.stream()
        .collect(Collectors.toMap(UserRecruitExtendRespDTO::getUserId, a -> a, (k1, k2) -> k2));

    pageResult.getList().forEach(v -> {
      v.setMobile(null == userInfoMap.get(v.getUserId()) ? null : userInfoMap.get(v.getUserId()).getMobile());
      v.setRealName(null == userExtendMap.get(v.getUserId()) ? null : userExtendMap.get(v.getUserId()).getRealName());
      v.setEmail(null == userExtendMap.get(v.getUserId()) ? null : userExtendMap.get(v.getUserId()).getEmail());
      v.setPosition(null == userRecruitExtendMap.get(v.getUserId()) ? null : userRecruitExtendMap.get(v.getUserId()).getPosition());
    });
    return pageResult;
  }

  /**
   * 修改绑定状态
   * @param bindingStateUpdateReqDTO
   */
  public BaseResponse updateBindingState(UserBindingStateUpdateReqDTO bindingStateUpdateReqDTO) {
    userBindingCompanyService.updateBindingState(bindingStateUpdateReqDTO);
    return BaseResponse.success("更新成功");
  }

  /**
   * 获取公司所有绑定用户
   * @param companyId
   * @return
   */
  public List<UserBindingExtendRespDTO> getAllBindingUser(Long companyId) {
    List<UserBindingExtendRespDTO> bindingUsers = userBindingCompanyService
        .getAllBindingUser(companyId);
    if (CollectionUtils.isEmpty(bindingUsers)) {
      return Lists.newArrayList();
    }

    Set<Long> userIds = bindingUsers.stream().map(UserBindingExtendRespDTO::getUserId)
        .collect(Collectors.toSet());
    // 获取用户拓展信息
    List<UserExtendRespDTO> userExtendRespDTOs = userExtendService.listUserExtendByUserIds(userIds);
    Map<Long, UserExtendRespDTO> userExtendMap = userExtendRespDTOs.stream()
        .collect(Collectors.toMap(UserExtendRespDTO::getUserId, a -> a, (k1, k2) -> k2));
    // 获取用户招聘拓展信息
    List<UserRecruitExtendRespDTO> userRecruitExtendRespDTOs = userRecruitExtendService.getByUserIds(userIds);
    Map<Long, UserRecruitExtendRespDTO> userRecruitExtendMap = userRecruitExtendRespDTOs.stream()
        .collect(Collectors.toMap(UserRecruitExtendRespDTO::getUserId, a -> a, (k1, k2) -> k2));

    bindingUsers.forEach(v -> {
      v.setRealName(null == userExtendMap.get(v.getUserId()) ? null : userExtendMap.get(v.getUserId()).getRealName());
      v.setPhotoUrl(null == userRecruitExtendMap.get(v.getUserId()) ?
          null : userRecruitExtendMap.get(v.getUserId()).getPhotoUrl());
    });
    return bindingUsers;
  }

  /**
   * 管理员身份转移
   * @param userBindingTransferReqDTO
   */
  public void managerTransfer(UserBindingTransferReqDTO userBindingTransferReqDTO) {
    userBindingCompanyService.managerTransfer(userBindingTransferReqDTO);
  }

  /**
   * 交接
   * @param userBindingTransferReqDTO
   */
  public void handover(UserBindingTransferReqDTO userBindingTransferReqDTO) {
    // 修改交接状态及交接人
    userBindingCompanyService.handover(userBindingTransferReqDTO);
    // 删除用户信息
    userInfoService.deleteUserInfo(userBindingTransferReqDTO.getUserId());
  }



}
