package com.github.xf717.userservice.rpc.user.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserInfoCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPersonalInfoRespDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户_帐号信息
 *
 * @author wst
 * @date 2021-03-29 12:47:48
 */
public interface UserInfoApi {

  /**
   * 添加数据
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/userInfo/save")
  BaseResponse save(@RequestBody UserInfoCreateReqDTO createReqDTO);

  /**
   * 创建用户
   *
   * @param createReqDTO
   * @return
   */
  @PostMapping("/facade/userInfo/createUserIfAbsent")
  ObjectRestResponse<UserInfoRespDTO> createUserIfAbsent(
      @RequestBody UserInfoCreateReqDTO createReqDTO);

  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/userInfo/update")
  BaseResponse update(@RequestBody UserInfoUpdateReqDTO updateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/userInfo/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);
  

  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/userInfo/list")
  ObjectRestResponse<List<UserInfoRespDTO>> listUserInfos(
      @RequestBody UserInfoListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/userInfo/page")
  TableResultResponse<UserInfoRespDTO> page(@RequestBody UserInfoPageReqDTO pageReqDTO);

  /**
   * 验证帐号密码
   *
   * @param username
   * @param password
   * @return
   */
  @PostMapping("/facade/userInfo/verify/password")
  ObjectRestResponse<UserInfoRespDTO> verifyPassword(@RequestParam("username") String username,
      @RequestParam("password") String password);

  /**
   * 更新数据
   *
   * @param username
   * @param password
   * @return
   */
  @PutMapping("/facade/userInfo/set/password")
  ObjectRestResponse<Boolean> setPassword(@RequestParam("username") String username,
      @RequestParam("password") String password);

  /**
   * 修改手机号码
   *
   * @param username
   * @param mobile
   * @return
   */
  @PutMapping("/facade/userInfo/update/mobile")
  ObjectRestResponse<Boolean> updateMobile(@RequestParam("username") String username,
      @RequestParam("mobile") String mobile);

  /**
   * 修改密码
   *
   * @param username
   * @param oldPassword
   * @param password
   * @return
   */
  @PutMapping("/facade/userInfo/update/password")
  ObjectRestResponse<Boolean> updatePassword(@RequestParam("username") String username,
      @RequestParam("oldPassword") String oldPassword,
      @RequestParam("password") String password);

  /**
   * 根据用户id查询个人资料
   * @param userId userId
   * @return
   */
  @GetMapping("/facade/userInfo/get/user/{userId}")
  ObjectRestResponse<UserPersonalInfoRespDTO> getUserInfoById(@PathVariable("userId") Long userId);

}
