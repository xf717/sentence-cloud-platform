package com.db.chaomaxs.userservice.manager.user;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.user.UserExtendConvert;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendDetailRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendDetailReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendUpdateEnableHideReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitUpdateReqDTO;
import com.db.chaomaxs.userservice.service.user.UserExtendService;
import com.db.chaomaxs.userservice.service.user.UserInfoService;
import com.db.chaomaxs.userservice.service.user.UserRecruitExtendService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserExtendManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Service
@Validated
public class UserExtendManager {

  @Autowired
  private UserExtendService userExtendService;

  @Autowired
  private UserInfoService userInfoService;

  @Autowired
  private UserRecruitExtendService userRecruitExtendService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserExtend(UserExtendCreateReqDTO createReqDTO) {
    return userExtendService.saveUserExtend(createReqDTO);
  }


  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserExtend(Long id) {
    return userExtendService.deleteUserExtend(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserExtendRespDTO> listUserExtends(UserExtendListQueryReqDTO listQueryReqDTO) {
    return userExtendService.listUserExtends(listQueryReqDTO);
  }



  /**
   * 根据用户id获取对象
   *
   * @param userId
   * @return
   */
  public UserExtendRespDTO getUserExtendByUserId(Long userId) {
    return userExtendService.getUserExtendByUserId(userId);
  }


  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserExtendRespDTO> pageUserExtend(UserExtendPageReqDTO page) {
    return userExtendService.pageUserExtend(page);
  }

  public List<UserExtendDetailRespDTO> listUserExtendByUserIds(
      UserExtendDetailReqDTO userExtendDetailReqDTO) {

    //根据用户ids 查找拓展信息
    List<UserExtendRespDTO> userExtendRespList = userExtendService
        .listUserExtendByUserIds(userExtendDetailReqDTO.getUserIds());
    Map<Long, UserExtendRespDTO> userExtendMap = userExtendRespList.stream()
        .collect(Collectors.toMap(UserExtendRespDTO::getUserId, a -> a, (k1, k2) -> k1));
    // 根据用户查询用户头像
    List<UserInfoRespDTO> userInfoRespList = userInfoService
        .listUserInfoByUserIds(userExtendDetailReqDTO.getUserIds());
    Map<Long, String> userInfoMap = userInfoRespList.stream()
        .collect(Collectors.toMap(UserInfoRespDTO::getId, UserInfoRespDTO::getAvatarUrl, (k1, k2) -> k1));
    List<UserExtendDetailRespDTO> userExtendListRespList = new ArrayList<>();
    for (Long userId : userExtendDetailReqDTO.getUserIds()) {
      UserExtendDetailRespDTO dto = new UserExtendDetailRespDTO();
      dto.setRealName(null == userExtendMap.get(userId) ? null
          : userExtendMap.get(userId).getRealName());
      dto.setCompanyId(null == userExtendMap.get(userId) ? null
          : userExtendMap.get(userId).getCompanyId());
      dto.setAvatarUrl(userInfoMap.get(userId));
      dto.setUserId(userId);
      userExtendListRespList.add(dto);
    }
    return userExtendListRespList;
  }

  /**
   * 更新是否隐藏简历数据
   *
   * @param updateEnableHideReqDTO
   * @return
   */
  public int updateEnableHideDTO(UserExtendUpdateEnableHideReqDTO updateEnableHideReqDTO) {
    return userExtendService.updateEnableHideDTO(updateEnableHideReqDTO);
  }

  /**
   * 修改用户招聘信息
   * @param userRecruitUpdateReqDTO
   * @returnc
   */
  public void updateUserRecruitInfo(UserRecruitUpdateReqDTO userRecruitUpdateReqDTO) {
    // 修改用户拓展信息
    userExtendService.updateUserExtendReqDto(userRecruitUpdateReqDTO);
    // 修改用户招聘拓展信息
    userRecruitExtendService.updateUserRecruitExtendByUserId(userRecruitUpdateReqDTO);
  }

  /**
   * 根据用户id查询用户信息和拓展信息
   * @param userId
   * @return
   */
  public UserExtendDetailRespDTO getUserExtendInfo(Long userId){
    UserExtendRespDTO userExtendResp = userExtendService.getUserExtendByUserId(userId);
    UserExtendConvert.INSTANCE.convert(userExtendResp);
    UserInfoRespDTO userInfo = userInfoService.getUserInfo(userId);
    return UserExtendConvert.INSTANCE.convert(userInfo);
  }
}
