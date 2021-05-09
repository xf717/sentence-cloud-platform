package com.github.xf717.userservice.rpc.user.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserExtendCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendDetailRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendDetailReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendUpdateEnableHideReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_基础信息扩展表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
public interface UserExtendApi {

  /**
   * 注册填写个人数据-添加
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/userExtend/save")
  BaseResponse save(@RequestBody UserExtendCreateReqDTO createReqDTO);


  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/userExtend/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);


  /**
   * 根据用户id查询拓展信息
   *
   * @param userId
   * @return
   */
  @GetMapping("/facade/userExtend/get/{userId}")
  ObjectRestResponse<UserExtendRespDTO> getUserExtendByUserId(@PathVariable("userId") Long userId);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/userExtend/list")
  ObjectRestResponse<List<UserExtendRespDTO>> listUserExtends(
      @RequestBody UserExtendListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/userExtend/page")
  TableResultResponse<UserExtendRespDTO> page(@RequestBody UserExtendPageReqDTO pageReqDTO);

  /**
   * 根据用户ids 查询用户信息以及拓展信息
   *
   * @param userExtendDetailReqDTO 查询参数
   * @return
   */
  @PostMapping("/facade/userExtend/list/userIds")
  ObjectRestResponse<List<UserExtendDetailRespDTO>> listUserExtendByUserIds(
      @RequestBody UserExtendDetailReqDTO userExtendDetailReqDTO);

  /**
   * 根据用户id 查询用户信息以及拓展信息
   *
   * @param userId 用户id
   * @return
   */
  @GetMapping("/facade/userExtend/get/userInfo/{userId}")
  ObjectRestResponse<UserExtendDetailRespDTO> getUserExtendInfo(@PathVariable("userId") Long userId);

  /**
   * 更新是否隐藏简历
   *
   * @param updateEnableHideReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/userExtend/enable/hide/update")
  BaseResponse updateEnableHideDTO(
      @RequestBody UserExtendUpdateEnableHideReqDTO updateEnableHideReqDTO);

  /**
   * 修改用户招聘信息
   *
   * @param userRecruitUpdateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/userExtend/recruit/Info/update")
  BaseResponse updateUserRecruitInfo(@RequestBody UserRecruitUpdateReqDTO userRecruitUpdateReqDTO);
}
